package com.boshi.controller;

import com.boshi.entity.User;
import com.boshi.service.UserService;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

  //日志
  private final Logger log = LoggerFactory.getLogger(UserController.class);
  @Autowired
  private UserService userService;
  //之定义
  @Value("${weixin.config.AppId}")
  private Integer appId;


  @RequestMapping("/get")
  @ResponseBody
  public String show() {
    String name = "wq";
    User user = userService.findUserByName(name);
    if (null != user) {
      return user.getId() + "/" + user.getName() + "/";
    } else {
      return "null";
    }
  }

  @ResponseBody
  @PostMapping("/login")
  public BaseResult login(String phoneNumber, String password,
      String mailbox, String valiCode, HttpServletResponse response) {
    try {
      Boolean status = userService.login(phoneNumber, password, mailbox, valiCode, response);
      if (status) {
        return BaseResult.Success();
      } else {
        return BaseResult.Error("登录失败，请重新登录！");
      }
    } catch (Exception e) {
      return BaseResult.Error("系统繁忙，请稍后重试！");
    }
  }

  @GetMapping("/home")
  public String home() {
    return "module/views/home";
  }

}