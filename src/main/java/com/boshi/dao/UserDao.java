package com.boshi.dao;


import com.boshi.entity.User;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

  @Select("SELECT * FROM tbl_user WHERE name = #{username}")
  User findByName(@Param("username") String username);

  public List<User> getList();

  User findByPhonceNumber(@Param("phoneNumber") String phoneNumber);
}
