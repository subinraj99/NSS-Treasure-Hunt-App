package com.codemaster.nsstreasurehunt.model;

public class UserDetails {
    public String uid;
    public String userName;
    public String college;
    public String email;

    public UserDetails(String uid, String userName, String college, String email) {
        this.uid = uid;
        this.userName = userName;
        this.college = college;
        this.email = email;
    }
}
