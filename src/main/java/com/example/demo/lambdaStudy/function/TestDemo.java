package com.example.demo.lambdaStudy.function;

import com.example.demo.lambdaStudy.entity.Student;

import java.util.function.Predicate;

/**
 * @author mayongbo
 * @Description
 * @date 2021/3/4 11:43
 */
public class TestDemo {

    public static void main(String[] args) {
        DemoHandler demoHandler = new DemoHandler();
        Student student = new Student();
        student.setName("andy");
        student.setAge(30);
        System.out.println("123456");
        for(int i =1; i <6;i++){
            long startTime = System.currentTimeMillis();
            System.out.println(String.format("onSuccessSetContext第 %d 次执行开始时间: " + startTime,i));
            demoHandler.onSuccessSetContext(student.toString(),student);
            System.out.println(String.format("onSuccessSetContext第 %d 次执行耗时: " + (System.currentTimeMillis() - startTime),i));
        }
        for(int i =1; i <6;i++){
            long startTime = System.currentTimeMillis();
            System.out.println(String.format("execute第 %d 次执行开始时间: " + startTime,i));
            EventTask<String> execute = demoHandler.execute(student.toString(), student);
            System.out.println(String.format("execute第 %d 次执行耗时: " + (System.currentTimeMillis() - startTime),i));
        }
        for(int i =1; i <6;i++){
            long startTime = System.currentTimeMillis();
            System.out.println(String.format("paramValidator第 %d 次执行开始时间: " + startTime,i));
            Predicate<Object> predicate = demoHandler.paramValidator(student.toString());
            System.out.println(String.format("paramValidator第 %d 次执行耗时: " + (System.currentTimeMillis() - startTime),i));
        }




    }

}
