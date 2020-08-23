package net.xdclass.rbac_shiro.dao;

import net.xdclass.rbac_shiro.domain.Role;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * @author : lipu
 * @since : 2020-08-23 19:13
 */
public interface RoleMapper {


    @Select("select r.id id, " +
            "r.name name," +
            "r.description description," +
            "r.create_time createTime " +
            "from user_role ur " +
            "left join role r on ur.role_id = r.id " +
            "where ur.user_id = #{userId}")
    @Results(
            value = {
                    @Result(id=true,property = "id",column = "id"),
                    @Result(id=true,property = "name",column = "name"),
                    @Result(id=true,property = "description",column = "description"),
                    @Result(id=true,property = "createTime",column = "createTime"),
                    @Result(id=true,property = "permissionList",column = "id",
                    many = @Many(select = "net.xdclass.rbac_shiro.dao.PermissionMapper.findPermissionListByRoleId",fetchType = FetchType.DEFAULT))
            }
    )
    List<Role> findRoleListByUserId(@Param("userId") int userId);




}
