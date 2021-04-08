package com.auth.web.service.impl;


import com.auth.web.entity.SysUserRole;
import com.auth.web.service.UserRoleService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 用户角色实现类
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Override
    public List<SysUserRole> listByUserId(String id) {
        return null;
    }
}
