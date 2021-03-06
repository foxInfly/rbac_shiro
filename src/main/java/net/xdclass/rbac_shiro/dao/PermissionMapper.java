package net.xdclass.rbac_shiro.dao;

import net.xdclass.rbac_shiro.domain.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : lipu
 * @since : 2020-08-23 19:13
 */
public interface PermissionMapper {


    @Select("select p.id id," +
            "p.name name, " +
            "p.url url," +
            "p.create_time createTime " +
            "from role_permission rp " +
            "left join permission p on rp.permission_id = p.id " +
            "where rp.role_id = #{roleId}")
    List<Permission> findPermissionListByRoleId(@Param("roleId") int roleId);




}
