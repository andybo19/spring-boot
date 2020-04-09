package com.example.demo.dao.user;

import com.example.demo.dao.user.sql.UserDaoSql;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.UpdateProvider;

@Mapper
public interface UserDao {

    @Select("SELECT * from user where mobile_number = #{mobile}")
    User findByMobile(String mobile);

    @Insert("INSERT INTO `user` (`user_name`, `mobile_number`) VALUES ( #{userName}, #{mobileNumber})")
    int insert(User user);

    @UpdateProvider(type = UserDaoSql.class,method = "updateSql")
    int update(User user);
}
