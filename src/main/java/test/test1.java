package test;


import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.SpringApplication;

public class test1 {

  public static void main(String[] args) throws Exception {
    test1 test = new test1();
    test.postParams();
  }

  public void postParams() {
    // 获取连接客户端工具
    CloseableHttpClient httpClient = HttpClients.createDefault();

    String entityStr = null;
    CloseableHttpResponse response = null;
    try {
      // 创建POST请求对象
      HttpPost httpPost = new HttpPost("http://192.168.0.181:9002/qc/a/versionName/list");
      /*
       * 添加请求参数
       */
//      // 创建请求参数
//      List<NameValuePair> list = new LinkedList<>();
//      BasicNameValuePair param1 = new BasicNameValuePair("username", "18780724180");
//      BasicNameValuePair param2 = new BasicNameValuePair("pass", "123456");
//      list.add(param1);
//      list.add(param2);
//      // 使用URL实体转换工具
//      UrlEncodedFormEntity entityParam = new UrlEncodedFormEntity(list, "UTF-8");
//      httpPost.setEntity(entityParam);
      /*
       * 添加请求头信息
       */
      // 浏览器表示
      httpPost.addHeader("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.6)");
      // 传输的类型
      httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded");
      //添加 Cookie
      httpPost.addHeader("Cookie", "JSESSIONID=AE5BE435D96DC712DB96B66BBFE3831F");
      // 执行请求
      response = httpClient.execute(httpPost);
      // 获得响应的实体对象
      HttpEntity entity = response.getEntity();
      // 使用Apache提供的工具类进行转换成字符串
      entityStr = EntityUtils.toString(entity, "UTF-8");
      System.out.println(Arrays.toString(response.getAllHeaders()));
    } catch (ClientProtocolException e) {
      System.err.println("Http协议出现问题");
      e.printStackTrace();
    } catch (ParseException e) {
      System.err.println("解析错误");
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println("IO异常");
      e.printStackTrace();
    } finally {
      // 释放连接
      if (null != response) {
        try {
          response.close();
          httpClient.close();
        } catch (IOException e) {
          System.err.println("释放连接出错");
          e.printStackTrace();
        }
      }
    }
    // 打印响应内容
    System.out.println(entityStr);
  }

}
