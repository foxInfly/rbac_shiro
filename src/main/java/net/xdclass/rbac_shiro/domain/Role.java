package net.xdclass.rbac_shiro.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**角色
 * @author : lipu
 * @since : 2020-08-23 19:07
 */
@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -8132664921218315468L;
    private int id;
    private String name;
    private String description;
    private Date createTime;

    //权限集合
    private List<Permission> permissionList;
}
