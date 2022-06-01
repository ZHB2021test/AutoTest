package com.test.jd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class StartJD2 {
    private static ChromeDriver chromeDriver;

    public static void main(String[] args) throws InterruptedException {
        int y = 1;
        openChrome();

        // 3、点击“你好，请登录”，然后扫码登录
        chromeDriver.findElement(By.linkText("你好，请登录")).click();
        Thread.sleep(12000);

        // 4、点击“购物车”，随后跳转至购物车窗口
        chromeDriver.findElement(By.linkText("我的购物车")).click();
        System.out.println("跳转后页面句柄为：" + chromeDriver.getWindowHandle());
        Thread.sleep(310);

        // 获取到所有的窗口句柄
        Set<String> handles = chromeDriver.getWindowHandles();
        // 对窗口集合进行遍历
        for (String handle : handles) {
            // 切换句柄
            chromeDriver.switchTo().window(handle);
            // 判断却换页面
            if (chromeDriver.getTitle().equals("京东商城 - 购物车")) {
                // 符合标题跳出循环
                break;
            }
        }
        Thread.sleep(310);

        WebElement webElement = chromeDriver.findElement(By.cssSelector("input[type=\"checkbox\"][name=\"select-all\"]"));
        System.out.println("得到元素的clstag属性:" + webElement.getAttribute("clstag"));

        // 5、点击购物车中的全选按钮
        while (true) {
            if (webElement.getAttribute("clstag").equals("pageclick|keycount|Shopcart_CheckAll|0")) {
                chromeDriver.findElement(By.cssSelector("input[type=\"checkbox\"][name=\"select-all\"]")).click();
                Thread.sleep(310);
                System.out.println("页面刷新次数：....." + y++);

                // 6、判断是否勾选“全选按钮” 备用code: else
                // if(webElement.getAttribute("clstag").equals("pageclick|keycount|Shopcart_CheckAll|1"))
            } else {
                chromeDriver.findElement(By.xpath("//a[@class=\"common-submit-btn\" and @href=\"#none\"]")).click();
                System.out.println("即将打开结算页面");

                // 7、跳转至付款页面
                chromeDriver.findElement(By.id("order-submit")).click();
                System.out.println("成功进入结算页面");
                break;
            }
        }
    }

    public static void openChrome() {
        // 1、打开chrome浏览器
        chromeDriver = new ChromeDriver();

        // 2、打开京东
        chromeDriver.get("https://www.jd.com/");
    }
}