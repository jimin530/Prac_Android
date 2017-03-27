package com.jmdroid.prac_server.network.reqmodel;

import com.jmdroid.prac_server.dto.LoginDTO;

/**
 * Created by jimin on 2017. 3. 27..
 */

public class ReqLogin {
    ReqHeader header;
    LoginDTO body;

    public ReqHeader getHeader() {
        return header;
    }

    public void setHeader(ReqHeader header) {
        this.header = header;
    }

    public LoginDTO getBody() {
        return body;
    }

    public void setBody(LoginDTO body) {
        this.body = body;
    }

    public ReqLogin(ReqHeader header, LoginDTO body) {

        this.header = header;
        this.body = body;
    }

    public ReqLogin() {

    }
}
