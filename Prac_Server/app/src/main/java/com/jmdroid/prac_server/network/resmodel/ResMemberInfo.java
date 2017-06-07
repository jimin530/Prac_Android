package com.jmdroid.prac_server.network.resmodel;

import java.lang.reflect.Member;
import java.util.ArrayList;

/**
 * Created by jimin on 2017. 4. 9..
 */

public class ResMemberInfo {
    ResHeader header;
    ArrayList<Member> body;

    public ResMemberInfo() {
    }

    public ResMemberInfo(ResHeader header, ArrayList<Member> body) {

        this.header = header;
        this.body = body;
    }

    public ResHeader getHeader() {

        return header;
    }

    public void setHeader(ResHeader header) {
        this.header = header;
    }

    public ArrayList<Member> getBody() {
        return body;
    }

    public void setBody(ArrayList<Member> body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "ResMemberInfo{" +
                "header=" + header +
                ", body=" + body +
                '}';
    }
}
