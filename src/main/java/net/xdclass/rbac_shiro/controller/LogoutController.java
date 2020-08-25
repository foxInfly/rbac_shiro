package net.xdclass.rbac_shiro.controller;

import net.xdclass.rbac_shiro.domain.JsonData;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : lipu
 * @since : 2020-08-24 23:30
 */
@RestController//返回json给前端
public class LogoutController {




  /*  @RequestMapping("/logout")
    public JsonData findMyRecord(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() != null) {

        }
        //退出
        SecurityUtils.getSubject().logout();
        return JsonData.buildSucess("logout成功");
    }*/
}
