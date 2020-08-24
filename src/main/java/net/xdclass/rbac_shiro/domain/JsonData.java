package net.xdclass.rbac_shiro.domain;

import lombok.Data;

/**返回实体类
 * @author : lipu
 * @since : 2020-08-24 21:44
 */
@Data
public class JsonData {

    private Integer code;//状态码  0表示成功，1表示处理中，-1表示失败
    private Object data;//数据
    private String msg;//描述
    private boolean flag;//是否成功，true成功，false失败

    public JsonData() {
    }

    public JsonData(Integer code, Object data, String msg, boolean flag) {
        this.code = code;
        this.data = data;
        this.msg = msg;
        this.flag = flag;
    }

    public static JsonData buildSucess(){return new JsonData(0,null,null,true);}
    public static JsonData buildSucess(Object data){return new JsonData(0,data,null,true);}
    public static JsonData buildSucess(Object data,String msg){return new JsonData(0,data,msg,true);}
    public static JsonData buildError(String msg){return new JsonData(-1,null,msg,false);}
    public static JsonData buildError(Object data){return new JsonData(-1,data,null,false);}
    public static JsonData buildError(Integer code,String msg){return new JsonData(code,null,msg,false);}
}
