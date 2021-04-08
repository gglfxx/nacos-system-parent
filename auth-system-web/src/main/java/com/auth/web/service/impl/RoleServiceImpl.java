package com.auth.web.service.impl;

import com.auth.web.entity.Result;
import com.auth.web.entity.Role;
import com.auth.web.service.RoleService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 角色实现类
 */
@Service
@Slf4j
public class RoleServiceImpl implements RoleService {


    @Override
    public Result<List<Role>> queryRole(Page<Role> page, String roleCode, String dictName) {
        return null;
    }

    @Override
    public Result<Role> findRoleById(String id) {
        return null;
    }

    @Override
    public Result<String> addOrUpdateRole(Role role) {
        return null;
    }

    @Override
    public Result<String> delRole(String id) {
        return null;
    }

    @Override
    public Result<String> enableRole(String id, String status) {
        return null;
    }

    @Override
    public Role selectById(String id) {
        return null;
    }
}
