package com.codemaster.nsstreasurehunt.model;

public class QuestionDetails {
    private String img;
    private boolean imgAvl;
    private String answer;

    public QuestionDetails() {
        //required
    }

    public QuestionDetails(String img, boolean imgAvl, String answer) {
        this.img = img;
        this.imgAvl = imgAvl;
        this.answer = answer;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isImgAvl() {
        return imgAvl;
    }

    public void setImgAvl(boolean imgAvl) {
        this.imgAvl = imgAvl;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
