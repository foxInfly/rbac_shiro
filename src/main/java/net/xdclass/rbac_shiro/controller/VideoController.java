package net.xdclass.rbac_shiro.controller;

import net.xdclass.rbac_shiro.domain.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**视频更新
 * @author : lipu
 * @since : 2020-08-24 23:26
 */
@RestController//返回json给前端
@RequestMapping("video")
public class VideoController {

    @RequestMapping("/update")
    public JsonData findMyRecord(){

        return JsonData.buildSucess("video更新成功");
    }
}
