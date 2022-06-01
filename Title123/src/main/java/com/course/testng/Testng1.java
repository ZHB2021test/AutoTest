package com.course.testng;

import org.testng.annotations.*;

public class Testng1 {

    // 标记测试的一部分
    @Test
    public void tell1 () {
        System.out.println("测试用例1号");
    }
    @Test
    public void tell4(){
        System.out.println("测试用例2号");
    }

    // 测试方法前运行
    @BeforeMethod
    public void tell2 () {
        System.out.println("测试前运行2号");
    }

    @AfterMethod
    public void tell3(){
        System.out.println("测试方法后运行3号");
    }

    // 类前运行
    @BeforeClass
    public void tell5(){
        System.out.println("类前运行5号");
    }

    // 类后运行
    @AfterClass
    public void tell6(){
        System.out.println("类后运行6号");
    }

    // 最先运行测试套件
    @BeforeSuite
    public void tell7(){
        System.out.println("测试套件最先运行7号");
    }

    // 最后运行
    @AfterSuite
    public void tell8(){
        System.out.println("最后运行的测试套件8号");
    }
}
