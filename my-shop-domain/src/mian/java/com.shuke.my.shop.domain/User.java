package com.shuke.my.shop.domain;
import java.io.Serializable;

public class User implements Serializable{
    private String email;
    private String loginPwd;
    private String loginId;

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", password='" + loginPwd + '\'' +
                ", username='" + loginId + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public String getLoginId() {
        return loginId;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
