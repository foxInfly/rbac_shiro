package net.xdclass.rbac_shiro.config;

import net.xdclass.rbac_shiro.domain.Permission;
import net.xdclass.rbac_shiro.domain.Role;
import net.xdclass.rbac_shiro.domain.User;
import net.xdclass.rbac_shiro.service.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : lipu
 * @since : 2020-08-23 19:02
 */
public class CustomRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;


    /**
     * 授权
     *
     * @author lipu
     * @since 2020/8/23 22:10
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("开始授权==========================");

        String username = (String) principals.getPrimaryPrincipal();
        User user = userService.findAllUserInfoByUsername(username);

        List<String> strigRoleList = new ArrayList<>();
        List<String> strigPermissionList = new ArrayList<>();

        user.getRoleList().stream().map(
                role -> {
                    strigRoleList.add(role.getName());
                    role.getPermissionList().stream().map(
                            permission -> strigPermissionList.add(permission.getName()));
                    return role;
                }
        ).collect(Collectors.toList());

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(strigRoleList);
        simpleAuthorizationInfo.addStringPermissions(strigPermissionList);


        return simpleAuthorizationInfo;
    }

    /**
     * 认证
     *
     * @author lipu
     * @since 2020/8/23 22:10
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("开始认证==========================");

        //从token中获取用户输入的信息
        String username = (String) token.getPrincipal();

        User user = userService.findAllUserInfoByUsername(username);

        //取密码
        String pwd = user.getPassword();
        if (pwd == null || "".equals(pwd)) {
            return null;
        }


        return new SimpleAuthenticationInfo(username, user.getPassword(), this.getClass().getName());
    }
}
