package com.jmdroid.prac_server.dto;

/**
 * Created by jimin on 2017. 3. 27..
 */

public class ChangePasswordDTO {
    String user_id;
    String user_beforepassword;
    String user_newpassword;

    public ChangePasswordDTO() {
    }

    public ChangePasswordDTO(String user_id, String user_beforepassword, String user_newpassword) {

        this.user_id = user_id;
        this.user_beforepassword = user_beforepassword;
        this.user_newpassword = user_newpassword;
    }

    public String getUser_id() {

        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_beforepassword() {
        return user_beforepassword;
    }

    public void setUser_beforepassword(String user_beforepassword) {
        this.user_beforepassword = user_beforepassword;
    }

    public String getUser_newpassword() {
        return user_newpassword;
    }

    public void setUser_newpassword(String user_newpassword) {
        this.user_newpassword = user_newpassword;
    }

    @Override
    public String toString() {
        return "ChangePasswordDTO{" +
                "user_id='" + user_id + '\'' +
                ", user_beforepassword='" + user_beforepassword + '\'' +
                ", user_newpassword='" + user_newpassword + '\'' +
                '}';
    }
}
