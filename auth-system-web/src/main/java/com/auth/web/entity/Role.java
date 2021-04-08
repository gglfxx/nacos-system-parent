package com.auth.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("t_online_role")
@Accessors(chain = true)
public class Role extends BaseEntity{

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField(value = "role_code")
    private String roleCode;

    @TableField(value = "role_name")
    private String roleName;

    @TableField(value = "role_desc")
    private String roleDesc;

    @TableField(value = "use_flag")
    private int useFlag;
}

