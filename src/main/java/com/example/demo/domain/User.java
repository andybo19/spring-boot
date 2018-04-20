package com.example.demo.domain;

public class User {

    public static final String USER_INTERIOR_MARK = "duanrongw";//内部员工标识
    //返利网来源标识
    public static final String FAN_LI_WANG = "fanliwang";
    //风车理财来源标识
    public static final String FENG_CHE_LI_CAI = "fengchelicai";

    private String id;

    private String userName;//用户名

    private String mobileNumber;//电话号码

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                '}';
    }
}
