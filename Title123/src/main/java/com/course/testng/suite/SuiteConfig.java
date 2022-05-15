package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


public class SuiteConfig {

    // 登录前的接口套件
    @BeforeSuite
    public void tell1(){
        System.out.println("测试前运行的测试套件1号----------------------");
    }

    // 登录后的接口套件
    @AfterSuite
    public void tell2(){
        System.out.println("测试后运行的测试套件2号------------------------");
    }

    // 用例运行前展示
    @BeforeTest
    public void tell3(){
        System.out.println("用例运行前展示3号");
    }
    // 用例运行前展示
    @AfterTest
    public void tell4(){
        System.out.println("用例运行后展示4号");
    }
}
