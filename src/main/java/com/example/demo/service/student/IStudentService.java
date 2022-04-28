package com.example.demo.service.student;

import com.example.demo.domain.Student;

/**
 * @author wan yu
 * @date 2022/3/21 下午3:05
 */
public interface IStudentService {

    int deleteByAgeAndClassId(Integer age, Integer classId);

    Student getByName(String name);
}
