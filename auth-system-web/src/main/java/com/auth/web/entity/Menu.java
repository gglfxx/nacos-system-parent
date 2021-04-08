package com.auth.web.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单类
 */
@Data
@NoArgsConstructor                 //无参构造
@AllArgsConstructor                //有参构造
public class Menu implements Serializable {

    private static final long serialVersionUID = -5750396617885069088L;

    private int id;

    private int parentId;

    private String title;

    private String icon;

    private String href;

    private String permission;

    private boolean spread;

    private String menuType;

    private int level;

    private int sort;

    private Date createTime;

    private Date updateTime;

    private String createUser;

    private String updateUser;

    private List<Menu> children;
}
