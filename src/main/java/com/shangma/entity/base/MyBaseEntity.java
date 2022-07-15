package com.shangma.entity.base;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author BOGEY
 * 2022/7/15  10:52
 */
@Data
public class MyBaseEntity implements Serializable {
    /**
     * mybatisplus 主键自动增加
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 创建者
     */
    private Long createBy;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 修改者
     */
    private Long updateBy;
    /**
     * 修改时间
     */
    private LocalDateTime updateTime;

}
