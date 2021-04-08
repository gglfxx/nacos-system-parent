package com.auth.web.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName("t_online_task_schedule")
@Accessors(chain = true)
public class SysTaskSchedule extends BaseEntity{

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField(value = "task_no")
    private String taskNo;

    @TableField(value = "task_name")
    private String taskName;

    @TableField(value = "task_group")
    private String taskGroup;

    @TableField(value = "task_class")
    private String taskClass;

    @TableField(value = "task_method")
    private String taskMethod;

    @TableField(value = "task_express")
    private String taskExpress;

    @TableField(value = "task_status")
    private int taskStatus;

    @TableField(value = "task_concurrent")
    private int taskConcurrent;

    @TableField(value = "delete_flag")
    private int deleteFlag;
}
