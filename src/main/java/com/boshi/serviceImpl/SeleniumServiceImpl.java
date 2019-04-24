package com.boshi.serviceImpl;

import com.boshi.service.SeleniumService;
import com.boshi.util.TestMail;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service("SeleniumService")
public class SeleniumServiceImpl implements SeleniumService {

  //日志
  private final Logger log = LoggerFactory.getLogger(SeleniumServiceImpl.class);

  public static void main(String[] args) throws InterruptedException {
    SeleniumServiceImpl seleniumServiceImpl = new SeleniumServiceImpl();
    seleniumServiceImpl.huLiAppShiZhong();
  }

//  @Override
//  public boolean huLiAppShiZhong() throws InterruptedException {
//    boolean Result = false;
//    System.setProperty("webdriver.chrome.driver", "F:\\test\\chromedriver.exe");
//    WebDriver driver = new ChromeDriver();
//    try {
//      driver.manage().window().maximize();
//      driver.get("http://192.168.0.181:9001/cas/login?service=http:"
//          + "//192.168.0.181:9001/base-web/a/cas");
//      driver.findElement(By.id("username")).sendKeys("admin");
//      driver.findElement(By.id("password")).sendKeys("123456");
//      driver.findElement(By.xpath("//*[@id=\"fm1\"]/div[4]/div/input")).click();
//      Thread.sleep(2000); //线程停止2秒
//      // 进入 id 叫mainFrame 的 iframe
//      driver.switchTo().frame("mainFrame");
//      driver.findElement(By.xpath("//*[@id=\"10\"]")).click();
//      // 回到主窗口
//      driver.switchTo().defaultContent();
//      Thread.sleep(3000); //线程停止3秒
//      // 得到当前窗口的set集合
//      Set<String> winHandels = driver.getWindowHandles();
//      // 将set集合存入list对象
//      List<String> it = new ArrayList<String>(winHandels);
//      // 切换到弹出的新窗口
//      driver.switchTo().window(it.get(1));
//      Thread.sleep(1000);
//      //获取新窗口的url
//      String url = driver.getCurrentUrl();
//      System.out.println(url);
//      driver.findElement(By.xpath("//*[@id=\"app\"]/section/section/aside/div[1]/ul/div/li[3]/div"))
//          .click();
//      Thread.sleep(1000);
//      driver.findElement(
//          By.xpath("//*[@id=\"app\"]/section/section/aside/div[1]/ul/div/li[3]/ul/div/li[1]"))
//          .click();
//      Thread.sleep(1000);
//      driver.findElement(By.xpath("//*[@id=\"pane-listData\"]/form/div[5]/div/button[3]")).click();
//      Thread.sleep(1000);
//      driver.findElement(By.xpath(
//          "//*[@id=\"pane-listData\"]/form/div[5]/div/div[1]/div/div[2]/div/div[3]/table/tbody/tr[15]/td[1]/div/label/span/span"))
//          .click();
//      Thread.sleep(1000);
//      driver.findElement(
//          By.xpath("//*[@id=\"pane-listData\"]/form/div[5]/div/div[1]/div/div[3]/span/button[2]"))
//          .click();
//      Thread.sleep(1000);
//      driver.findElement(
//          By.xpath("//*[@id=\"listTable\"]/div[3]/table/tbody/tr/td[1]/div/label/span")).click();
//      Thread.sleep(1000);
//      driver.findElement(By.xpath("//*[@id=\"pane-listData\"]/form/div[5]/div/button[4]")).click();
//      Thread.sleep(1000);
//      driver.findElement(
//          By.xpath("//*[@id=\"pane-listData\"]/form/div[5]/div/div[2]/div/div[3]/span/button[2]"))
//          .click();
//      Thread.sleep(1000);
//      //关闭浏览器
//      driver.quit();
//      Result = true;
//    } catch (Exception e) {
//      log.error(e.getMessage(), e);
//      driver.quit();
//    } finally {
//      if (driver != null) {
//        driver.quit();
//      }
//    }
//    return Result;
//  }

  @Override
  public boolean huLiAppShiZhong() throws InterruptedException {
    boolean Result = false;
    System.setProperty("webdriver.chrome.driver", "F:\\test\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    try {
      driver.manage().window().maximize();
      driver.get("http://www.threegene.com/");
      Thread.sleep(8000); //线程停止2秒
      driver.findElement(By.xpath("//*[@id=\"topnav_6\"]")).click();
      Thread.sleep(3000); //线程停止2秒
      String youXiang = driver
          .findElement(By.xpath("/html/body/div/div[3]/div/div/div/div[2]/ul/li[6]")).getText();
      //发送邮件
      String mailbox = "95108181@qq.com";
      TestMail testMail = new TestMail();
      testMail.sendMail(mailbox, "三代人科技您好", "这是你的邮箱号：" + youXiang.substring(3));
      log.info(youXiang.substring(3));
      //关闭浏览器
      driver.quit();
      Result = true;
    } catch (Exception e) {
      log.error(e.getMessage(), e);
      driver.quit();
    } finally {
      if (driver != null) {
        driver.quit();
      }
    }
    return Result;
  }
}
