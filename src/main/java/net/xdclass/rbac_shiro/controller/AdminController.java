package net.xdclass.rbac_shiro.controller;

import net.xdclass.rbac_shiro.domain.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**订单
 * @author : lipu
 * @since : 2020-08-24 22:19
 */
@RestController//返回json给前端
@RequestMapping("admin")
public class AdminController {


    @RequestMapping("/video/order")
    public JsonData findMyRecord(){
        Map<String,Object> recordMap = new HashMap<>();

        recordMap.put("SpringBoot入门到高级实战","300元");
        recordMap.put("Cloud微服务入门到高级实战","877元");
        recordMap.put("分布式缓存Redis","990元");

        return JsonData.buildSucess(recordMap);
    }

}
