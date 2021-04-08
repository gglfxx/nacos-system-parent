package com.auth.web.service;


import com.auth.web.entity.Result;
import com.auth.web.entity.Role;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * 角色接口
 */
public interface RoleService {

    /**
     * 查询角色
     * @param page
     * @param roleCode
     * @param dictName
     * @return
     */
    Result<List<Role>> queryRole(Page<Role> page, String roleCode, String dictName);

    /**
     * 根据id查询角色详情
     * @param id
     * @return
     */
    Result<Role> findRoleById(String id);

    /**
     * 新增角色
     * @param role
     * @return
     */
    Result<String> addOrUpdateRole(Role role);

    /**
     * 删除角色
     * @param id
     * @return
     */
    Result<String> delRole(String id);

    /**
     * 禁用启用角色
     * @param id
     * @param status
     * @return
     */
    Result<String> enableRole(String id,String status);

    /**
     * 根据角色id查询角色
     * @param id
     * @return
     */
    Role selectById (String id);
}
