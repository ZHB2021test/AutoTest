package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("用例1号");
    }

    // 忽略测试
    @Test(enabled = false)
    public void ignore2(){
        System.out.println("用例2号");
    }
    @Test(enabled = true)
    public void ignore3(){
        System.out.println("用例3号");
    }
}
