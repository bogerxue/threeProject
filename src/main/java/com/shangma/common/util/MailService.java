package com.shangma.common.util;

import com.shangma.entity.User;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;

/**
 * @author BOGEY
 * 2022/6/30  22:56
 */
@Component
public class MailService implements Serializable {
    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private FreeMarkerConfigurer freeMarkerConfigurer;

    public void sendLoginCodeMail(String email, String code) {
        // 创建简单邮件发送对象
        SimpleMailMessage smm = new SimpleMailMessage();
        // 邮件的发送者
        smm.setFrom("尚马教育<bogerxue@foxmail.com>");
        // 邮件的接收者
        smm.setTo(email);
        // 邮件的主题
        smm.setSubject("登录验证码");
        // 邮件的内容
        smm.setText("您的验证码是:\t" + code);

//        javaMailSender.send(smm);todo
    }

    public void sendMailByUpload() throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        //消息帮助器
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("薛文博<bogerxue@foxmail.com>");
        helper.setTo("809609490@qq.com");
        helper.setSubject("邮件主题2");
        helper.setText("<h1>这也是一条内容<h1><img src='cid:id'><img>", true);
        helper.addInline("id", new File("E:\\SMThree\\ssm_mail\\web\\img\\photo1.png"));
        javaMailSender.send(mimeMessage);
    }

    public String getTemplateEmailStr(Object dataModel, String templateName) {
        // 获取配置对象
        Configuration configuration = freeMarkerConfigurer.getConfiguration();
        StringWriter sw = null;
        try {
            // 获取模板对象
            Template template = freeMarkerConfigurer.getConfiguration().getTemplate(templateName);
            // 向内存中写入一个字符串
            sw = new StringWriter();
            template.process(dataModel, sw);
        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }
        // 从内存流中获取字符串
        assert sw != null;
        return sw.toString();
    }

    public void sendActivationEmail(User user, String string) {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
        try {
            helper.setFrom("尚马教育<bogerxue@foxmail.com>");
            helper.setTo(user.getUserEmail());
            helper.setSubject("这是一封激活邮件");
            helper.setText(string, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mimeMessage);

    }

}
