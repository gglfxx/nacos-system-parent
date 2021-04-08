package com.auth.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@TableName(value = "t_online_dict_content")
@Accessors(chain = true)
public class DictionaryContent extends BaseEntity{
    private static final long serialVersionUID = 4161364235771241313L;

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField(value = "dict_id")
    private String dictId;

    @TableField(value = "code")
    private String code;

    @TableField(value = "name")
    private String name;

    @TableField(value = "sort")
    private int sort;
}
