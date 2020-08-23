package net.xdclass.rbac_shiro.domain;

import lombok.Data;

import java.util.Date;

/**角色权限
 * @author : lipu
 * @since : 2020-08-23 19:08
 */
@Data
public class RolePermission {

    private int id;
    private int roleId;
    private int permissionId;
    private String remarks;
    private Date createTime;
}
