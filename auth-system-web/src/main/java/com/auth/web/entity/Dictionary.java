package com.auth.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 字典实体类
 */
@Data
@TableName("t_online_dict")
@Accessors(chain = true)
public class Dictionary extends BaseEntity{

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField(value = "dict_code")
    private String dictCode;

    @TableField(value = "dict_name")
    private String dictName;

    @TableField(value = "description")
    private String description;

    @TableField(value = "use_flag")
    private int useFlag;

    @TableField(value = "sort")
    private int sort;
}
