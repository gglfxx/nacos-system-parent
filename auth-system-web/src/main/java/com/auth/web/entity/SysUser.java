package com.auth.web.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;


/**
 * 用户表
 */
@Data
@TableName("t_online_user")
@Accessors(chain = true)
public class SysUser extends BaseEntity{

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "name")
    private String name;

    @TableField(value = "birthday")
    private String birthday;

    @TableField(value = "password",fill = FieldFill.INSERT)
    private String password;

    @TableField(value = "id_num")
    private String idNum;

    @TableField(value = "sex")
    private int sex;

    @TableField(value = "phone")
    private String phone;

    @TableField(value = "email")
    private String email;

    @TableField(value = "address")
    private String address;

    @TableField(value = "province")
    private String province;

    @TableField(value = "city")
    private String city;

    @TableField(value = "area")
    private String area;

    @TableField(value = "head_url")
    private String headUrl;

    @TableField(value = "use_flag")
    private int useFlag;
}
