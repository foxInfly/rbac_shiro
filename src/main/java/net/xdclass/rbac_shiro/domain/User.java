package net.xdclass.rbac_shiro.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户
 * @author : lipu
 * @since : 2020-08-23 19:06
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = 6957932828961836710L;
    private int id;
    private String username;
    private String password;
    private String salt;
    private Date createTime;

    //角色集合
    private List<Role> roleList;

    //权限集合
    private List<Permission> permissionList;
}
