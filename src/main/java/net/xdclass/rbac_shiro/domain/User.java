package net.xdclass.rbac_shiro.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 用户
 * @author : lipu
 * @since : 2020-08-23 19:06
 */
@Data
public class User {
    private int id;
    private String username;
    private String salt;
    private Date createTime;

    //角色集合
    private List<Role> roleList;

    //权限集合
    private List<Permission> permissionList;
}
