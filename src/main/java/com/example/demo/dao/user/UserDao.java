package com.example.demo.dao.user;

import com.example.demo.dao.user.sql.UserDaoSql;
import com.example.demo.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Select("SELECT * from `t_user`  where mobile_number = #{mobile}")
    User findByMobile(String mobile);

    @Insert("INSERT INTO `t_user` (`user_name`, `mobile_number`) VALUES ( #{userName}, #{mobileNumber})")
    int insert(User user);

    @UpdateProvider(type = UserDaoSql.class,method = "updateSql")
    int update(User user);

    @Delete("delete from `t_user` where id = #{id}")
    int delete(int id);
}
