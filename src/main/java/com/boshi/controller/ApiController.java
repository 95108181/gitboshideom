package com.boshi.controller;

import com.boshi.service.ApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/api")
public class ApiController {

  //日志
  private final Logger log = LoggerFactory.getLogger(ApiController.class);
  @Autowired
  private ApiService apiService;

  @GetMapping("/singleInterface")
  public String singleInterface() {
    return "module/views/singleInterface";
  }

  @GetMapping("/apiExcl")
  public String apiExcl(){
    apiService.apiExcl();
    String a = "成功";
    return "a";
  }

  @ResponseBody
  @PostMapping("/cheShe")
  public BaseResult cheShe(String url, String cookie, String chanShu, String qingQiu) {
    try {
      String jieGuo = apiService.cheShe(url, cookie, chanShu, qingQiu);
      return BaseResult.Success(jieGuo);
    } catch (Exception e) {
      return BaseResult.Error("系统繁忙，请稍后重试！");
    }
  }

}