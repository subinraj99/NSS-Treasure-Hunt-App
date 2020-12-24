package com.codemaster.nsstreasurehunt.model;

public class OnGoingDetails {
    private String currQno;
    private Object time;

    public OnGoingDetails() {
        // Default constructor required
    }

    public OnGoingDetails(String currQno, Object time) {
        this.currQno = currQno;
        this.time = time;
    }

    public String getCurrQno() {
        return currQno;
    }

    public void setCurrQno(String currQno) {
        this.currQno = currQno;
    }

    public Object getTime() {
        return time;
    }

    public void setTime(Object time) {
        this.time = time;
    }
}
