package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Groups {

    @Test(groups = "server")
    public void tese1(){
        System.out.println("服务端1号");
    }
    @Test(groups = "server")
    public void tese2(){
        System.out.println("服务端2号");
    }
    @Test(groups = "client")
    public void tese3(){
        System.out.println("客户端3号");
    }

    @Test(groups = "client")
    public void tese4(){
        System.out.println("客户端4号");
    }
    @BeforeGroups("server")
    public void tese5(){
        System.out.println("用例前运行5号----------");
    }
    @AfterGroups("client")
    public void tese6(){
        System.out.println("用例后运行6号------------");
    }

}
