package com.example.demo.lambdaStudy.function;

import com.example.demo.lambdaStudy.entity.Student;
import org.springframework.util.StringUtils;

import java.util.function.Predicate;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/4 11:28
 */
public class DemoHandler {

    public DemoHandler(){

    }

    public Predicate<Object> paramValidator(String logStr) {
        return (o-> !StringUtils.isEmpty(logStr));
    }

    public EventTask<String> execute(String logStr, Student student) {
        return (() -> {
            System.out.println("编号B执行..." + System.currentTimeMillis());
            return student.toString();
        });
    }

    public void onSuccessSetContext(String logStr, Student student) {
        /*student.toString();*/
    }

}
