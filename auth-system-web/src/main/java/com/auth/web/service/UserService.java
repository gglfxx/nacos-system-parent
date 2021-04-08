package com.auth.web.service;

import com.auth.web.entity.Result;
import com.auth.web.entity.SysUser;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;


import java.util.List;

/**
 * 用户
 */
public interface UserService {
    //根据用户名查找用户信息
    SysUser findByUsername(String username);
    //根据用户主键查询菜单权限
    List<String> findPermissionsByUserId(String id);
    //根据用户主键查询角色
    List<String> findRoleNameByUserId(String id);
    //用户查询页
    Result<List<SysUser>> findUser(Page<SysUser> page, String username, String sex, String name);
    //禁用启用用户
    Result<String> enableUser(String id, String status);
    //新增用户
    Result<String> addOrUpdateUser(SysUser user);
    //删除用户
	Result<String> delUser(String id);
    //根据用户id查询详情
    Result<SysUser> findUserById(String id);
    //根据用户名修改密码
    Result<String> changePwd(SysUser user);
}
