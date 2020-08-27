package net.xdclass.rbac_shiro.service.impl;

import net.xdclass.rbac_shiro.dao.RoleMapper;
import net.xdclass.rbac_shiro.dao.UserMapper;
import net.xdclass.rbac_shiro.domain.Role;
import net.xdclass.rbac_shiro.domain.User;
import net.xdclass.rbac_shiro.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : lipu
 * @since : 2020-08-23 21:36
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private RoleMapper roleMapper;


    @Resource
    private UserMapper userMapper;

    @Override
    public User findAllUserInfoByUsername(String username) {
        //todo 加缓存

        User user = userMapper.findByUsername(username);
        List<Role> roleList = roleMapper.findRoleListByUserId(user.getId());
        user.setRoleList(roleList);
        return user;
    }

    @Override
    public User findSimpleUserInfoById(int userId) {
        return userMapper.findById(userId);
    }

    @Override
    public User findSimpleUserInfoByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
