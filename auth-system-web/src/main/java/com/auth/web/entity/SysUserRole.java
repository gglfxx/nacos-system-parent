package com.auth.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 用户角色关系表
 */
@Data
@TableName("t_online_user_role")
@Accessors(chain = true)
public class SysUserRole {

    @TableField(value = "user_id")
    private String userId;

    @TableField(value = "role_id")
    private String roleId;
}
