package com.shangma.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.shangma.common.http.AxiosResult;
import com.shangma.common.http.AxiosStatus;
import com.shangma.common.util.JedisUtil;
import com.shangma.common.util.MailService;
import com.shangma.controller.base.MyBaseController;
import com.shangma.entity.User;
import com.shangma.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author BOGEY
 * 2022/6/30  22:33
 */
@RestController
@RequestMapping("login")
public class LogInController extends MyBaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;



    @PostMapping("loginIn")
    public AxiosResult getCode(@RequestParam String userEmail) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getUserEmail, userEmail);
        List<User> users = userService.searchObject(wrapper);
        Jedis jedis = JedisUtil.getJedis();
        if (users.isEmpty()) {
            System.out.println("用户不在数据库中");
            return AxiosResult.getInstance(AxiosStatus.EMAIL_NOT_FOUND);
        } else {
            jedis.set("logInUser", JSON.toJSONString(users.get(0)));
            // 如果存在
            //    判断邮箱是否被激活
            if (users.get(0).getUserStatus() == 1) {
                //        如果激活了，直接发送验证码邮件
                //   发送验证码
                String code = UUID.randomUUID().toString().substring(0, 6);
                System.out.println(code);
                jedis.set(userEmail, code);
                jedis.expire(userEmail,60*2);
                mailService.sendLoginCodeMail(userEmail, code);
                return AxiosResult.getInstance(AxiosStatus.OK);
            } else {
                //        如果没有激活，返回前端邮箱未激活，让用户去激活
                return AxiosResult.getInstance(AxiosStatus.ADMIN_NOT_ACTIVE);
            }
        }
    }

    /**
     * email:用户的邮箱
     * code 用户输入的验证码
     */
    @PostMapping("checkCode")
    @ResponseBody
    public AxiosResult checkCode(String userEmail, String userCode) {
        // 验证验证码
        // 获取真正生成的验证码
        Jedis jedis = JedisUtil.getJedis();
        String realCode = jedis.get(userEmail);
        if (realCode.equalsIgnoreCase(userCode)) {
            jedis.del(userEmail);
            return AxiosResult.getInstance(AxiosStatus.OK);
        } else {
            return AxiosResult.getInstance(AxiosStatus.CODE_CHECK_ERROR);
        }

    }

    @PostMapping("sendActiveEmail")
    @ResponseBody
    public AxiosResult sendActiveEmail(String userEmail) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getUserEmail, userEmail);
        List<User> users = userService.searchObject(wrapper);
        if (users.get(0) != null && users.get(0).getUserStatus() == 0) {
            Map<String, String> map = new HashMap<>();
            map.put("UserLoginName", users.get(0).getUserLoginName());
            map.put("activeUrl", "http://localhost:8080/login/doActive/" + users.get(0).getId());
            String templateEmailStr = mailService.getTemplateEmailStr(map, "active.ftl");
            run(users.get(0), templateEmailStr);
            return AxiosResult.getInstance(AxiosStatus.OK);
        } else {
            return AxiosResult.getInstance(AxiosStatus.ERROR);
        }
    }

    @Async
    public void run(User user, String templateEmailStr) {
        mailService.sendActivationEmail(user, templateEmailStr);
    }


    @GetMapping("doActive/{userId}")
    public String doAct(@PathVariable Long userId) {
        // 根据id查找到最新的对象
        User user = userService.findObjectById(userId);
        // 更改对象中的激活字段为true
        user.setUserStatus(1);
        // 更新对象的数据到数据库中
        userService.updateObject(user);
        return "redirect:/success.html";
    }

}
