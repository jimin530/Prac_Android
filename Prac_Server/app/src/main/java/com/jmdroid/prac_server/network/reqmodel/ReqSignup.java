package com.jmdroid.prac_server.network.reqmodel;

import com.jmdroid.prac_server.dto.SignupDTO;

/**
 * Created by jimin on 2017. 3. 26..
 */

public class ReqSignup {
    ReqHeader header;
    SignupDTO body;

    public ReqSignup(){}

    public ReqSignup(ReqHeader header, SignupDTO body) {
        this.header = header;
        this.body = body;
    }

    public ReqHeader getHeader() {
        return header;
    }

    public void setHeader(ReqHeader header) {
        this.header = header;
    }

    public SignupDTO getBody() {
        return body;
    }

    public void setBody(SignupDTO body) {
        this.body = body;
    }
}
