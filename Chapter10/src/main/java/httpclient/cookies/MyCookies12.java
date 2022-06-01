package httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookies12 {

    private String url;
    private ResourceBundle bundle;

    // 用来存储cookies信息变量
    private CookieStore store;

    @BeforeTest
    public void Test123(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void Test124() throws IOException {
        String result;

        // 从配置中拼接url
        String uri = bundle.getString("getCookies.uri");
        String testUrl = this.url+uri;

        // 测试逻辑书写
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity(),"utf-8");
        System.out.println(result);

        // 获取cookies信息
        this.store = client.getCookieStore();
        List<Cookie> cookieList = store.getCookies();

        for (Cookie cookie : cookieList){
            String name = cookie.getName();
            String value = cookie.getValue();
            System.out.println("cookie name = "+name+"  ;cookie value = "+value);

        }
    }

    @Test(dependsOnMethods = {"Test124"})
    public void testGetWithCookies() throws IOException {
        // 从配置中拼接url
        String uri = bundle.getString("test.get.with.cookies");
        String testUrl = this.url+uri;
        System.out.println(testUrl);
        HttpGet get = new HttpGet(testUrl);
        DefaultHttpClient client = new DefaultHttpClient();

        // 设置coolies信息
        client.setCookieStore(this.store);
        HttpResponse response = client.execute(get);

        // 获取响应状态码
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("statusCode="+statusCode);

        if (statusCode == 200){
            String result = EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }


    }
}
