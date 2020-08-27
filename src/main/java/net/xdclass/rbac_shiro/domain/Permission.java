package net.xdclass.rbac_shiro.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**权限
 * @author : lipu
 * @since : 2020-08-23 19:07
 */
@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = 135462797238687609L;
    private int id;
    private String name;
    private String url;
    private Date createTime;
}
