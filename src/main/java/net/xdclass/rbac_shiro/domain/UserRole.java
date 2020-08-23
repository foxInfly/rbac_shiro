package net.xdclass.rbac_shiro.domain;

import lombok.Data;

import java.util.Date;

/**
 * @author : lipu
 * @since : 2020-08-23 19:08
 */
@Data
public class UserRole {

    private int id;
    private int userId;
    private int roleId;
    private String remarks;
    private Date createTime;
}
