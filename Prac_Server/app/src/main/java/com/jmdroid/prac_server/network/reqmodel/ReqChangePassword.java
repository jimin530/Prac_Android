package com.jmdroid.prac_server.network.reqmodel;

import com.jmdroid.prac_server.dto.ChangePasswordDTO;

/**
 * Created by jimin on 2017. 3. 27..
 */

public class ReqChangePassword {
    ReqHeader header;
    ChangePasswordDTO body;

    public ReqChangePassword() {
    }

    public ReqChangePassword(ReqHeader header, ChangePasswordDTO body) {

        this.header = header;
        this.body = body;
    }

    public ReqHeader getHeader() {

        return header;
    }

    public void setHeader(ReqHeader header) {
        this.header = header;
    }

    public ChangePasswordDTO getBody() {
        return body;
    }

    public void setBody(ChangePasswordDTO body) {
        this.body = body;
    }
}
