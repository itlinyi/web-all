package com.itlinyi.schedule.test;

import com.itlinyi.schedule.util.MD5Util;
import org.junit.jupiter.api.Test;

/**
 * @author 林一
 * @version 1.0
 */
public class TestMD5Util {
    @Test
    public void testEncrypt() {
        String encrypt = MD5Util.encrypt("123456");
        System.out.println(encrypt);
    }
}
