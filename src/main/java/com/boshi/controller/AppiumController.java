package com.boshi.controller;

import com.boshi.service.AppiumService;
import java.net.MalformedURLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/Appium")
public class AppiumController {

  //日志
  private final Logger log = LoggerFactory.getLogger(AppiumController.class);
  @Autowired
  AppiumService appiumService;

  @GetMapping("/huLiAppShiZhong")
  public String huLiAppShiZhong() {
    return "module/views/shiZhong";
  }


  @GetMapping("/huLiApp")
  public String huLiApp() throws MalformedURLException {
    boolean Result = appiumService.huLiApp();
    if (Result == true) {
      return "module/views/chenGong";
    } else {
      return "module/views/shiBai";
    }
  }
}