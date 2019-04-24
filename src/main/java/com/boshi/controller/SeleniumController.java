package com.boshi.controller;

import com.boshi.service.SeleniumService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/selenium")
public class SeleniumController {

  //日志
  private final Logger log = LoggerFactory.getLogger(SeleniumController.class);
  @Autowired
  SeleniumService seleniumService;

  @GetMapping("/huLiSelenium")
  public String huLiAppShiZhong() throws InterruptedException {
    boolean Result = seleniumService.huLiAppShiZhong();
    if (Result == true) {
      return "module/views/chenGong";
    } else {
      return "module/views/shiBai";
    }
  }


}