package com.mindskip.examonline;

import com.mindskip.examonline.utility.Md5Util;

/**
 * @Description TODO
 * @Version 1.0
 * @Author shenlin
 * @Date 2021/1/9 下午7:30
 */


public class Test {

    @org.junit.Test
    public void testMD5(){
        String psw = Md5Util.encode("12345");
        System.out.println(psw);
    }
}
