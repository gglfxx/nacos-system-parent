package com.auth.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * 操作日志实体类
 */
@Data
@TableName("t_online_log")
@Accessors(chain = true)
public class OperationLog  implements Serializable{

    private static final long serialVersionUID = -4160067017269316094L;
    //主键
    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField(value = "oper_type")
    private String operType;

    //日志类型
    @TableField(value = "log_type")
    private String logType;

    //模块名
    @TableField(value = "module")
    private String module;

    @TableField(value = "description")
    private String description;

    @TableField(value = "req_param")
    private String reqParam;

    @TableField(value = "exc_name")
    private String excName;

    @TableField(value = "exc_message")
    private String excMessage;

    @TableField(value = "username")
    private String username;

    @TableField(value = "name")
    private String name;

    @TableField(value = "ip")
    private String ip;

    @TableField(value = "url")
    private String url;

    @TableField(value = "create_time")
    private Date createTime;

    @TableField(value = "version")
    private String version;

    @TableField(value = "method")
    private String method;

    @TableField(value = "browser")
    private String browser;

    @TableField(value = "oper_sys")
    private String operSys;
}
