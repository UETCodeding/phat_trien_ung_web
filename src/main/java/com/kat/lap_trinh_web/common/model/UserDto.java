package com.kat.lap_trinh_web.common.model;

import java.io.Serializable;
import java.util.Date;

public class UserDto implements Serializable {
    private int userId;
    private String userName;
    private String fullName;
    private String password;
    private int userType;
    private int status;
    private int code;
    private Date birthday;
    private String training;
    private String email;
    public UserDto() {
    }

    public UserDto(int userId, String userName, String fullName, String password, int userType, int status, int code, Date birthday, String email, String training) {
        this.userId = userId;
        this.userName = userName;
        this.fullName = fullName;
        this.password = password;
        this.userType = userType;
        this.status = status;
        this.code = code;
        this.birthday = birthday;
        this.email = email;
        this.training = training;
    }

    @Override
    public UserDto clone(){
        return new UserDto(this.userId, this.userName, this.fullName, this.password, this.userType, this.status, this.code, this.birthday, this.email, this.training);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getBirthdayToString() {
        return  birthday.toString();
    }
    public Date getBirthday() {
        return  birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getTraining() {
        return training;
    }

    public void setTraining(String training) {
        this.training = training;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
