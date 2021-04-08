package com.auth.web.service.impl;

import com.auth.web.entity.Result;
import com.auth.web.entity.SysUser;
import com.auth.web.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public SysUser findByUsername(String username) {
        return null;
    }

    @Override
    public List<String> findPermissionsByUserId(String id) {
        return null;
    }

    @Override
    public List<String> findRoleNameByUserId(String id) {
        return null;
    }

    @Override
    public Result<List<SysUser>> findUser(Page<SysUser> page, String username, String sex, String name) {
        return null;
    }

    @Override
    public Result<String> enableUser(String id, String status) {
        return null;
    }

    @Override
    public Result<String> addOrUpdateUser(SysUser user) {
        return null;
    }

    @Override
    public Result<String> delUser(String id) {
        return null;
    }

    @Override
    public Result<SysUser> findUserById(String id) {
        return null;
    }

    @Override
    public Result<String> changePwd(SysUser user) {
        return null;
    }
}
