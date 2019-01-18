package com.example.demo.dao.user.sql;

import com.example.demo.domain.User;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class UserDaoSql {

    public String updateSql(final User user){
        return new SQL(){

            {
                UPDATE("user");

                if(!StringUtils.isEmpty(user.getUserName())){
                    SET("user_name = #{userName}");
                }


                if(!StringUtils.isEmpty(user.getMobileNumber())){
                    SET("mobile_number = #{mobileNumber}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }
}
