package net.xdclass.rbac_shiro.controller;

import net.xdclass.rbac_shiro.domain.User;
import net.xdclass.rbac_shiro.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author : lipu
 * @since : 2020-08-23 21:33
 */
@RestController
@RequestMapping("pub")
public class PublicController {

    @Resource
    private UserService userService;

    @RequestMapping("find_user_info")
    public User findUserInfo(@RequestParam("username") String username) {
        return userService.findAllUserInfoByUsername(username);
    }
}
