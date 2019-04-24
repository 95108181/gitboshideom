package com.boshi.serviceImpl;

import com.boshi.controller.ApiController;
import com.boshi.service.ApiService;
import com.boshi.util.JsonFormatTool;
import com.boshi.util.ReadExcel;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("ApiService")
public class ApiServiceImpl implements ApiService {

  //日志
  private final Logger log = LoggerFactory.getLogger(ApiController.class);
  JsonFormatTool jsonFormatTool = new JsonFormatTool();

  @Override
  public String cheShe(String url, String cookie, String chanShu, String qingQiu) {
    String requestUrl = null;
    String jieGuo = null;
    try {
      if (qingQiu == "GET") {
        requestUrl = url + "?" + chanShu;
      } else {
        requestUrl = url;
      }
      URL realUrl = new URL(requestUrl);
      URLConnection conn = realUrl.openConnection();
      conn.setRequestProperty("Cookie", cookie);
      //指定客户端能够接收的内容类型
      conn.setRequestProperty("accept", "*/*");
      //设置连接的状态
      conn.setRequestProperty("connection", "Keep-Alive");
      //User-Agent:告诉HTTP服务器， 客户端使用的操作系统和浏览器的名称和版本.
      conn.setRequestProperty("user-agent",
          "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/68.0.3440.106 Safari/537.36");
      conn.setRequestProperty("Charset", "UTF-8");
      BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      String str = "";
      while ((line = in.readLine()) != null) {
        str += line;
      }
//      jsonObj = JSONObject.fromObject(str);
//        jieGuo = jsonFormatTool.formatJson(str);
      jieGuo = str;
      log.info(jieGuo);
    } catch (MalformedURLException e) {
      log.error("URL协议、格式或者路径错误！" + e);
      e.printStackTrace();
    } catch (IOException e) {
      log.error("URL连接失败！" + e);
      e.printStackTrace();
    } catch (Exception e) {
      log.error("发送  POST 请求出现异常！" + e);
      e.printStackTrace();
    }
    return jieGuo;
  }

  @Override
  public void apiExcl() {
    File file = new File("D:/wq.xls");
    ReadExcel readExcel = new ReadExcel();
    List excelList = readExcel.readExcel(file);
    //循环遍历每一行
    for (int i = 1; i < excelList.size(); i++) {
      //获取每一行的元素
      List list = (List) excelList.get(i);
      System.out.println();
    }
  }


}
