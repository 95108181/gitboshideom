package com.boshi.serviceImpl;

import static java.lang.Thread.sleep;

import com.boshi.service.AppiumService;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Service;

@Service("AppiumService")
public class AppiumServiceImpl implements AppiumService {

//  @Override
//  public boolean huLiApp() throws MalformedURLException {
//    boolean Result = false;
//    DesiredCapabilities capabilities = new DesiredCapabilities();
//    capabilities.setCapability("deviceName", "PFSNU18504106755");
//    capabilities.setCapability("automationName", "Appium");
//    capabilities.setCapability("platformName", "Android");
//    capabilities.setCapability("platformVersion", "7.0");
//    capabilities.setCapability("appPackage", "com.android.calculator2");
//    capabilities.setCapability("appActivity", ".Calculator");
////    appium提供的一种输入法，可以传中文。测试时直接用这个输入法
//    capabilities.setCapability("unicodeKeyboard", "True");
//    //程序结束时重置原来的输入法
////    capabilities.setCapability("resetKeyboard", "True");
//    //不初始化手机app信息（类似不清楚缓存）
////    capabilities.setCapability("noReset", "True");
//    AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
//    double Screen_X = driver.manage().window().getSize().width;//获取手机屏幕宽度
//    double Screen_Y = driver.manage().window().getSize().height;//获取手机屏幕高度
//    System.out.println(Screen_X + "---------------------" + Screen_Y);
//    try {
//      driver.closeApp();
//      //通过xpath +
//      sleep(1000);
//      driver.findElement(By.xpath("//android.view.ViewGroup"
//          + "[@content-desc=\"第 1 屏，共 2 屏\"]/android."
//          + "view.ViewGroup/android.view.ViewGroup/android.widget.TextView[2]")).click();
//      sleep(1000);
//      driver.findElement(By.id("username")).
//          sendKeys("H00210");
//      sleep(1000);
//      //模拟手指点击操作
//      driver.tap(1, 900, 650, 500);
//      sleep(1500);
//      driver.tap(1, 900, 650, 500);
//      sleep(800);
//      driver.tap(1, 99, 784, 500);
//      sleep(800);
//      driver.tap(1, 282, 791, 500);
//      sleep(800);
//      driver.tap(1, 480, 791, 500);
//      sleep(800);
//      driver.tap(1, 664, 791, 500);
//      sleep(800);
//      driver.tap(1, 1842, 713, 500);
//      sleep(1500);
//      driver.findElement(By.xpath("\t/hierarchy/android.widget.FrameLayout"
//          + "/android.widget.LinearLayout/android.widget.FrameLayout"
//          + "/android.widget.LinearLayout/android.widget.FrameLayout"
//          + "/android.support.v4.widget.DrawerLayout"
//          + "/android.widget.FrameLayout/android.webkit.WebView"
//          + "/android.webkit.WebView/android.view.View"
//          + "/android.view.View/android.view.View[4]/android.widget.Button")).click();
//      sleep(7000);
//      driver.tap(1, 1468, 586, 500);
//      //第一次删除
//      sleep(3000);
//      driver.tap(1, 1700, 300, 1500);
//      sleep(1500);
//      driver.tap(1, 1300, 685, 500);
//      sleep(1500);
//      //第二次删除
//      driver.tap(1, 1700, 300, 1500);
//      sleep(1500);
//      driver.tap(1, 1300, 685, 500);
//      sleep(2000);
//      driver.findElement(By.xpath(
//          "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.GridView/android.view.View[1]/android.view.View[5]/android.view.View/android.widget.EditText"))
//          .click();
//      sleep(2000);
//      driver.pressKeyCode(AndroidKeyCode.KEYCODE_Z);
//      sleep(2000);
//      //打开签名
////      driver.tap(1, 1700, 810, 500);
//      driver.findElement(By.xpath(
//          "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[2]/android.widget.GridView/android.view.View[8]/android.view.View[2]/android.view.View/android.widget.Button")
//      ).click();
//      sleep(2000);
//      //模拟手指滑动操作
//      driver.swipe(650, 600, 1000, 600, 1000);
//      sleep(2000);
//      driver.tap(1, 1450, 950, 500);
//      sleep(2000);
//      driver.findElement(By.xpath(
//          "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View[3]/android.widget.Button[4]"))
//          .click();
//      sleep(2000);
//      driver.tap(1, 1285, 685, 500);
//      sleep(2000);
//      driver.findElement(By.xpath(
//          "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.support.v4.widget.DrawerLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.view.View[2]/android.view.View[4]/android.view.View[2]/android.widget.GridView/android.view.View[1]/android.view.View[10]/android.view.View/android.widget.Button[1]"))
//          .click();
//      sleep(10000);
//      driver.closeApp();
//      Result = true;
//    } catch (Exception e) {
//      System.out.println(e);
//      driver.quit();
//    } finally {
//      driver.quit();
//    }
//    return Result;
//  }

  @Override
  public boolean huLiApp() throws MalformedURLException {
    boolean Result = false;
    for (int i = 0; i <= 1; ) {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("deviceName", "A5RNW17C21001280");
      capabilities.setCapability("automationName", "Appium");
      capabilities.setCapability("platformName", "Android");
      capabilities.setCapability("platformVersion", "8.0.0");
      capabilities.setCapability("appPackage", "com.ss.android.ugc.aweme");
      capabilities.setCapability("appActivity", ".splash.SplashActivity");
      //appium提供的一种输入法，可以传中文。测试时直接用这个输入法
//    capabilities.setCapability("unicodeKeyboard", "True");
      //程序结束时重置原来的输入法
//    capabilities.setCapability("resetKeyboard", "True");
      //不初始化手机app信息（类似不清楚缓存）
      capabilities.setCapability("noReset", "True");
      AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
          capabilities);
      try {
        double Screen_X = driver.manage().window().getSize().width;//获取手机屏幕宽度
        double Screen_Y = driver.manage().window().getSize().height;//获取手机屏幕高度
        System.out.println(Screen_X + "---------------------" + Screen_Y);
        sleep(8000);
        for (i = 0; i <= 0; ) {
          //模拟手指点击操作
          driver.tap(1, 986, 1033, 500);
          sleep(700);
          //模拟手指点击操作
          driver.swipe(500, 1500, 500, 400, 1000);
          sleep(7000);
        }
      } catch (Exception e) {
        System.out.println("报错：" + e);
      } finally {
        driver.quit();
        i = 0;
      }
    }
    return Result;
  }

}
