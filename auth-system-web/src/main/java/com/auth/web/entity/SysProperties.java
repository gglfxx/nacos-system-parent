package com.auth.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 配置实体
 */
@Data
@TableName("t_online_sys_config")
@Accessors(chain = true)
public class SysProperties extends BaseEntity{

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField(value = "sys_code")
    private String sysCode;

    @TableField(value = "sys_name")
    private String sysName;

    @TableField(value = "sys_val")
    private String sysVal;

}
