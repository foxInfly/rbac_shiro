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
@RequestMapping("authc")
public class OrderController {


    @RequestMapping("/video/play_record")
    public JsonData findMyPlayRecord(){
        Map<String,Object> recordMap = new HashMap<>();

        recordMap.put("Mysql","数据库");
        recordMap.put("redis","缓存");
        recordMap.put("shiro","认证");

        return JsonData.buildSucess(recordMap);
    }

}
