package net.xdclass.rbac_shiro.service;

import net.xdclass.rbac_shiro.domain.User;

/**
 * @author : lipu
 * @since : 2020-08-23 21:33
 */
public interface UserService {


    /**获取全部应用信息，包括角色、权限
     * @author lipu
     * @since 2020/8/23 21:35
     */
    User findAllUserInfoByUsername(String username);

    /**根据id获取用户基本信息
     * @author lipu
     * @since 2020/8/23 21:36
     */
    User findSimpleUserInfoById(int userId);

    /**根据username获取用户基本信息
     * @author lipu
     * @since 2020/8/23 21:36
     */
    User findSimpleUserInfoByUsername(String username);
}
