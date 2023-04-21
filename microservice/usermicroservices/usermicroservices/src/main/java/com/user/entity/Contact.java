package com.user.entity;

public class Contact {
    private int cid;
    private String name;
    private String email;
    private long userid;

    public Contact(int cid, String name, String email, long userid) {
        this.cid = cid;
        this.name = name;
        this.email = email;
        this.userid = userid;
    }

    public Contact() {
    }


    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }


}
