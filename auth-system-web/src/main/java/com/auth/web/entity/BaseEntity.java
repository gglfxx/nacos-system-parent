package com.auth.web.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class BaseEntity  implements Serializable {

    private static final long serialVersionUID = 5051777130379684354L;

    @TableField(value = "create_user", fill = FieldFill.INSERT) // 新增执行
    private String createUser;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(value = "update_user", fill = FieldFill.INSERT_UPDATE) // 新增和更新执行
    private String updateUser;

    @TableField(value = "update_Time", fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
}
