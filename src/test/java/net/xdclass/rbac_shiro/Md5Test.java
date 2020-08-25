package net.xdclass.rbac_shiro;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.junit.jupiter.api.Test;

/**
 * @author : lipu
 * @since : 2020-08-25 21:38
 */
public class Md5Test {


    @Test
    public void testMD5(){

        String hashName = "md5";

        String pwd = "123456";

        SimpleHash hash = new SimpleHash(hashName, pwd, null, 2);

        System.out.println(hash);


    }
}
