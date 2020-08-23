package net.xdclass.rbac_shiro.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**角色
 * @author : lipu
 * @since : 2020-08-23 19:07
 */
@Data
public class Role {
    private int id;
    private String name;
    private String description;
    private Date createTime;

    //权限集合
    private List<Permission> permissionList;
}
