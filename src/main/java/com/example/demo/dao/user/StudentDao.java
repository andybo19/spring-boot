package com.example.demo.dao.user;

import com.example.demo.domain.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @author wan yu
 * @date 2022/3/21 下午3:00
 */
@Mapper
public interface StudentDao {

    @Select("SELECT * from `student`  where name = #{name}")
    Student findByName(String name);

    @Delete("delete from `student` where age = #{age} and class_id = #{classId}")
    int deleteByAgeAndClassId(@Param("age") Integer age, @Param("classId") Integer classId);
}
