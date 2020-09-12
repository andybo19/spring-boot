package com.example.demo.domain;

public class User {

    private Integer id;

    private String userName;//用户名

    private String mobileNumber;//电话号码

    private Integer cate1Id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getCate1Id() {
        return cate1Id;
    }

    public void setCate1Id(Integer cate1Id) {
        this.cate1Id = cate1Id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", cate1Id=" + cate1Id +
                '}';
    }
}
