package com.example.demo.dao;

import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("SELECT * from user where mobile_number = #{mobile}")
    User findByMobile(String mobile);

    @Insert("INSERT INTO `duanrong`.`user` (`user_name`, `mobile_number`) VALUES ( #{userName}, #{mobileNumber})")
    void insert(User user);


}
