package net.xdclass.rbac_shiro.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : lipu
 * @since : 2020-08-23 22:51
 */
@Configuration
public class ShiroConfig {


    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        System.out.println("执行ShiroFilterFactoryBean.shiroFilter()");

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

        //必须设置securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        //需要登录的接口，前后端是调接口，非分离直接跳页面
        shiroFilterFactoryBean.setLoginUrl("/pub/need_login");

        //登陆成功跳转url，如果前后端分离，则没有这个调用
        shiroFilterFactoryBean.setSuccessUrl("/");

        //登陆成功，但没有权限，调用此接口.   先验证登录-->再验证是否有权限
        shiroFilterFactoryBean.setUnauthorizedUrl("/pub/not_permit");


        //拦截路径
        //   坑1:部分路径无法进行拦截，时有时无；是因为使用了HashMap（无需），要使用有序的LinkedHashMap
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        //退出过滤器
        filterChainDefinitionMap.put("/logout", "logout");
        //匿名可以访问的路径（游客模式）
        filterChainDefinitionMap.put("/pub/**", "anon");
        //登录才可以访问的
        filterChainDefinitionMap.put("/authc/**", "authc");

        //管理员角色才可以访问
        filterChainDefinitionMap.put("/admin/**", "roles[admin]");

        //有编辑权限才可以访问
        filterChainDefinitionMap.put("/video/update", "perms[video_update]");


        //   坑2:过滤链是顺序执行，从上而下，一般将/**放在最下面
        filterChainDefinitionMap.put("/**", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }


    @Bean
    public SecurityManager securityManager() {
        System.out.println("执行ShiroFilterFactoryBean.securityManager()");
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //主要针对前后端分离
        securityManager.setSessionManager(sessionManager());
        //设置realm，（推荐放到最后，防止摩尔写方法下不会调用）
        securityManager.setRealm(customRealm());

        return securityManager;
    }

    /**自定义realm
     * @author lipu
     * @since 2020/8/24 21:40
     */
    @Bean
    public CustomRealm customRealm(){
        System.out.println("执行ShiroFilterFactoryBean.customRealm()");
        CustomRealm customRealm = new CustomRealm();

        //开启加密
//        customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return customRealm;
    }

    /**密码器
     * @author lipu
     * @since 2020/8/23 23:22
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        System.out.println("执行ShiroFilterFactoryBean.hashedCredentialsMatcher()");
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();

        //设置散列算法：这里用MD5
        credentialsMatcher.setHashAlgorithmName("md5");

        //散列次数，好比散列2次，md5(md5(xxx))
        credentialsMatcher.setHashIterations(2);

        return credentialsMatcher;
    }


    /**自定义管理Session
     * @author lipu
     * @since 2020/8/23 23:26
     */
    @Bean
    public SessionManager sessionManager(){
        System.out.println("执行ShiroFilterFactoryBean.sessionManager()");
        CustomSessionManager customSessionManager = new CustomSessionManager();
        //设置会话超时时间，默认30分钟，会话过期，单位毫秒
        customSessionManager.setGlobalSessionTimeout(200*1000);

        return customSessionManager;
    }

}
