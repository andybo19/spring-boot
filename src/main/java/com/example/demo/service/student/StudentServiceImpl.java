package com.example.demo.service.student;

import com.example.demo.dao.user.StudentDao;
import com.example.demo.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author wan yu
 * @date 2022/3/21 下午3:08
 */
@Service
public class StudentServiceImpl implements IStudentService{

    @Autowired
    private StudentDao studentDao;

    @Transactional
    @Override
    public int deleteByAgeAndClassId(Integer age, Integer classId) {
        return studentDao.deleteByAgeAndClassId(age, classId);
    }

    @Override
    public Student getByName(String name) {
        return studentDao.findByName(name);
    }
}
