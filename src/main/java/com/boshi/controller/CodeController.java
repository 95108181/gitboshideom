package com.boshi.controller;

import com.boshi.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/comment")
public class CodeController {

  @Autowired
  CodeService codeService;

  @ResponseBody
  @PostMapping("/sendCode")
  public BaseResult SendCode(String phone, String mailbox) {
    try {
      Boolean status = codeService.SendCode(phone, mailbox);
      if (status) {
        return BaseResult.Success();
      } else {
        return BaseResult.Error("发送失败！");
      }
    } catch (Exception e) {
      return BaseResult.Error("发送失败！");
    }
  }


}
