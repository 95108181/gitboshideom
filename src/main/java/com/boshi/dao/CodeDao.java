package com.boshi.dao;

import org.apache.ibatis.annotations.Param;

public interface CodeDao {

  public void SendCode(@Param("phone") String phone, @Param("sendCode") String sendCode);

}
