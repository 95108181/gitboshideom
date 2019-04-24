package com.boshi.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import net.sf.json.JSONObject;

public class ApiRequestUtil {

  public static void main(String[] args){
    Map<String,Object> mapParam = new HashMap<String,Object>();
    JSONObject str = sendPost("http://192.168.0.181:9002/qc/a/indexTemp/list?pageSize=20&pageNum=1", mapParam);
    System.out.println(str);
  }

  /**
   * 向指定url发送POST请求
   *
   */
  public static JSONObject sendPost(String url,Map<String, Object> paramMap){
    JSONObject jsonObj = null;
//    if(url != "https:/Your URL!"){
//      //获取token，这里是OAuth 2.0认证
//      paramMap.put("access_token", getToken());
//    }
    try {
      URL realUrl = new URL(url);
      URLConnection conn = realUrl.openConnection();
      conn.setRequestProperty("Cookie", "JSESSIONID=07DFA0C0D52833340A85848C2B2AA217");
      //指定客户端能够接收的内容类型
      conn.setRequestProperty("accept", "*/*");
      //设置连接的状态
      conn.setRequestProperty("connection", "Keep-Alive");
      //User-Agent:告诉HTTP服务器， 客户端使用的操作系统和浏览器的名称和版本.
      conn.setRequestProperty("user-agent",
          "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
      conn.setRequestProperty("Charset", "UTF-8");
//      conn.setDoOutput(true);
//      conn.setDoInput(true);
//      PrintWriter out = new PrintWriter(conn.getOutputStream());
//      String param = mapToParam(paramMap);
//      out.print(param);
//      out.flush();
      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      String str = "";
      while ((line = in.readLine()) != null) {
        str += line;
      }
//      jsonObj = JSONObject.fromObject(str);
      System.err.println(str);
    } catch (MalformedURLException e) {
      System.err.println("URL协议、格式或者路径错误！" + e);
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println("URL连接失败！" + e);
      e.printStackTrace();
    } catch (Exception e) {
      System.err.println("发送  POST 请求出现异常！" + e);
      e.printStackTrace();
    }
    return jsonObj;
  }


  /**
   * 向指定url发送GET请求
   *
   */
  public static JSONObject sendGet(String url,Map<String,Object> paramMap){
    JSONObject jsonObj = null;
//    paramMap.put("access_token", getToken());
    try {
//      String requestUrl=url + "?" + mapToParam(paramMap);
      String requestUrl=url;
      URL realUrl = new URL(requestUrl);
      URLConnection conn = realUrl.openConnection();
      conn.setRequestProperty("accept", "*/*");
      conn.setRequestProperty("connection", "Keep-Alive");
//      conn.setRequestProperty("user-agent","Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
//      conn.setRequestProperty("Charset", "UTF-8");
      conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
      conn.setRequestProperty("Charset", "UTF-8");
      conn.connect();
      System.out.println("接口连接成功");

      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String str = "";
      String line;
      while ((line = in.readLine()) != null) {
        str += line;
      }
//      jsonObj = JSONObject.fromObject(str);
      System.out.println(str);
    } catch (MalformedURLException e) {
      System.err.println("URL协议、格式或者路径错误！" + e);
      e.printStackTrace();
    } catch (IOException e) {
      System.err.println("URL连接失败！" + e);
      e.printStackTrace();
    } catch (Exception e) {
      System.err.println("发送  GET 请求出现异常！" + e);
      e.printStackTrace();
    }
    return jsonObj;
  }

  /**
   * 将Map形式的参数转为url参数
   * @Title mapToParam
   */
  public static String mapToParam(Map<String,Object> paramMap){
    //取出Map里的数据拼接请求参数
    String param = "";
    if (paramMap != null && paramMap.size() > 0) {
      Iterator<String> ite = paramMap.keySet().iterator();
      while (ite.hasNext()) {
        String key = ite.next();// key
        Object value = paramMap.get(key);
        param += key + "=" + value + "&";
      }
      param = param.substring(0, param.length() - 1);
    }
    return param;
  }

  /**
   * 获取access_token权限认证令牌（token）
   */
  public static String getToken(){
    Map<String,Object> mapParam = new HashMap<String,Object>();//请求参数
    mapParam.put("grant_type", "password");
    mapParam.put("参数名","参数值");//这里的参数按照要求传就好
    mapParam.put("redirect_uri","http://www.baidu.com/");
    mapParam.put("username","");
    mapParam.put("password","");
    String pathUrl = "获取token的URL";
    Map<String,Object> result = sendPost(pathUrl, mapParam);
    System.out.println(result.toString());
    return (String) result.get("access_token");
  }
}