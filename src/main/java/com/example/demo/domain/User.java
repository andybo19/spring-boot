package com.example.demo.domain;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder*/
public class User {

    private Long id;

    private String userName;//用户名

    private String mobileNumber;//电话号码

    private String age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static void main(String[] args) throws Exception {

        String type = "com.example.demo.domain.User";

        Class<?> paramType = Class.forName(type);
        Object newArg = paramType.newInstance();
        List<Field> fieldList = new ArrayList();
        while (paramType != null) {
            Field[] declaredFields = paramType.getDeclaredFields();
            List<Field> fields = Stream.of(declaredFields).collect(Collectors.toList());
            fieldList.addAll(fields);
            paramType = paramType.getSuperclass();
        }
        for (Field f : fieldList) {
            String typeName = f.getType().toString();
            System.out.println(f.getName() + " : " + typeName);
        }

    }
}
