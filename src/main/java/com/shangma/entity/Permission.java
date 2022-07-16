package com.shangma.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.shangma.entity.base.MyBaseEntity;
import lombok.Data;


/**
 * @author BOGEY
 * 2022/7/14  21:19
 */
@Data
@TableName("a_permission")
public class Permission extends MyBaseEntity {

    /**
     * 实现了Serializable接口，实现序列化。
     * 设置唯一Uid 序列化时不会发生改变
     */
    private static final long serialVersionUID = 12345678901L;

    private String permissionName;
    private long permissionLevel;
    private long parentId;
    private String permissionUrl;


}
