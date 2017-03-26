package com.jmdroid.prac_server.dto;

/**
 * Created by jimin on 2017. 3. 26..
 */

public class SignupDTO {
    String user_id;
    String user_password;
    String user_name;

    public SignupDTO(){}

    @Override
    public String toString() {
        return "SignupDTO{" +
                "user_id='" + user_id + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public SignupDTO(String user_id, String user_password, String user_name) {
        this.user_id = user_id;
        this.user_password = user_password;
        this.user_name = user_name;
    }
}
