package com.boshi.service;


import com.boshi.entity.User;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

  public User findUserByName(String name);

  public List<User> getList();

  Boolean login(String phoneNumber, String password, String mailbox, String valiCode,
      HttpServletResponse response);
}
