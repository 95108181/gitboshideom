package com.boshi.serviceImpl;

import com.boshi.dao.CodeDao;
import com.boshi.dao.UserDao;
import com.boshi.entity.User;
import com.boshi.service.UserService;
import com.boshi.util.Base64;
import com.boshi.util.RedisUtil;
import java.util.List;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

  @Autowired
  UserDao userDao;
  @Autowired
  CodeDao codeDao;
  @Autowired
  RedisUtil redisUtil;

  public User findUserByName(String name) {
    return userDao.findByName(name);
  }

  public List<User> getList() {
    return userDao.getList();
  }


  @Override
  public Boolean login(String phoneNumber, String password,
      String mailbox, String valiCode, HttpServletResponse response) {
    User user = userDao.findByPhonceNumber(phoneNumber);
    if (redisUtil.get(phoneNumber).equals(valiCode)
        && user.getPassword().equals(password)) {
      Cookie cookie = new Cookie("code", Base64.getBase64(phoneNumber));
      cookie.setMaxAge(-1);
      cookie.setPath("/");
      response.addCookie(cookie);
      return true;
    } else {
      return false;
    }
  }
}
