package com.auth.web.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 图片类
 */
@Data
@TableName("t_online_file")
@Accessors(chain = true)
public class ImageVideo extends BaseEntity {

    @TableId(value = "id",type = IdType.UUID)
    private String id;

    @TableField(value="title")
    private String title;

    @TableField(value="simple_name")
    private String simpleName;

    @TableField(value="description")
    private String description;

    @TableField(value="res_type")
    private String resType;

    @TableField(value="url")
    private String url;

    @TableField(value="module")
    private String module;

}
