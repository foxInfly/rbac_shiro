package net.xdclass.rbac_shiro.config;

import org.apache.shiro.web.servlet.ShiroHttpServletRequest;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.Serializable;

/**自定义SessionManger
 * 主要针对前后端分离
 * @author : lipu
 * @since : 2020-08-23 23:23
 */
public class CustomSessionManager extends DefaultWebSessionManager {

    private static final String AUTHORIZATION = "token";

    public CustomSessionManager() {
        super();
    }

    @Override
    protected Serializable getSessionId(ServletRequest request, ServletResponse response) {
        
        String sessionId = WebUtils.toHttp(request).getHeader(AUTHORIZATION);
        System.out.println("请求端拿到的sessionId="+sessionId);

        if (sessionId != null) {
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_SOURCE,
                    ShiroHttpServletRequest.COOKIE_SESSION_ID_SOURCE);


            //校验sessionId
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID, sessionId);
            //automatically mark it valid here.  If it is invalid, the
            //onUnknownSession method below will be invoked and we'll remove the attribute at that time.
            request.setAttribute(ShiroHttpServletRequest.REFERENCED_SESSION_ID_IS_VALID, Boolean.TRUE);
            return sessionId;
        }else {
            return super.getSessionId(request, response);
        }
    }
}
