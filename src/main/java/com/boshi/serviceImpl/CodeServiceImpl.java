package com.boshi.serviceImpl;

import com.boshi.controller.UserController;
import com.boshi.dao.CodeDao;
import com.boshi.service.CodeService;
import com.boshi.util.RedisUtil;
import com.boshi.util.TestMail;
import java.util.Random;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("CodeService")
public class CodeServiceImpl implements CodeService {
  //日志
  private final Logger log = LoggerFactory.getLogger(UserController.class);

  @Autowired
  CodeDao codeDao;
  @Autowired
  RedisUtil redisUtil;

  @Override
  public Boolean SendCode(String phone, String mailbox) throws Exception {
    try{
      //产生6位随机数
      Random random = new Random();
      String sendCode = "";
      for (int i = 0; i < 6; i++) {
        sendCode += random.nextInt(10);
      }
      //存入rrdis
      redisUtil.set(phone, sendCode);
      //存入数据库
      codeDao.SendCode(phone, sendCode);
      //发送邮件
      TestMail testMail = new TestMail();
      testMail.sendMail(mailbox, "Java Mail", "【测试登录】" + sendCode+"（登录验证码，请完成验证），如非本人操作，请忽略本信息。");
      log.info(sendCode);
      return true;
    }catch (Exception e){
      log.error("验证码错误信息",e);
      return false;
    }
  }
}
