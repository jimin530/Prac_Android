package com.jmdroid.prac_server.dto;

/**
 * Created by jimin on 2017. 4. 9..
 */

public class MemberInfoDTO {
    String user_id;
    String user_name;

    public MemberInfoDTO() {
    }

    public MemberInfoDTO(String user_id, String user_name) {

        this.user_id = user_id;
        this.user_name = user_name;
    }

    public String getUser_id() {

        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    @Override
    public String toString() {
        return "MemberInfoDTO{" +
                "user_id='" + user_id + '\'' +
                ", user_name='" + user_name + '\'' +
                '}';
    }
}
