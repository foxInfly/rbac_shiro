package net.xdclass.rbac_shiro.controller;

import net.xdclass.rbac_shiro.domain.JsonData;
import net.xdclass.rbac_shiro.domain.User;
import net.xdclass.rbac_shiro.domain.UserQuery;
import net.xdclass.rbac_shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : lipu
 * @since : 2020-08-23 21:33
 */
@RestController
@RequestMapping("pub")
public class PublicController {

    @Resource
    private UserService userService;

    @RequestMapping("find_user_info")
    public User findUserInfo(@RequestParam("username") String username) {
        return userService.findAllUserInfoByUsername(username);
    }

    @RequestMapping("need_login")
    public JsonData needLogin(){
        return JsonData.buildError (-2,"温馨提示：您还未登录，请登录后访问");
    }

    @RequestMapping("not_permit")
    public JsonData notPermit(){
        return JsonData.buildError (-3,"温馨提示：拒绝访问，没有权限");
    }

    @RequestMapping("index")
    public JsonData index(){
        List<String> videoList = new ArrayList<>();
        videoList.add("Mysql零基础入门到实战 数据库教程");
        videoList.add("Redis高并发高可用集群百万级秒杀实战");
        videoList.add("Zookeeper+Dubbo视频教程 微服务教程分布式教程");
        videoList.add("2019年新版本RocketMQ4.X教程消息队列教程");
        videoList.add("微服务SpringCloud+Docker入门到高级实战");
        return JsonData.buildSucess (videoList);
    }

    @PostMapping("login")
    public JsonData login(@RequestBody UserQuery userQuery, HttpServletRequest request, HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        Map<String,Object> info = new HashMap<>();

        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userQuery.getName(), userQuery.getPwd());
            System.out.println("usernamePasswordToken: "+usernamePasswordToken);

            subject.login(usernamePasswordToken);

            info.put("msg","登陆成功");
            info.put("session_id",subject.getSession().getId());
            System.out.println("登陆后的信息： "+info);
            return JsonData.buildSucess (info);
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return JsonData.buildError ("账号或者密码错误");
        }
    }
}
