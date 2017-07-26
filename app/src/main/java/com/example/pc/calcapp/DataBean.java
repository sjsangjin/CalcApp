package com.example.pc.calcapp;

/**
 * Created by pc on 2017-07-05.
 */

public class DataBean {     //데이터 그룹핑을 위해 생성
    private  int resImg;
    private String imgText;

    public DataBean(int resImg, String imgText){
        this.resImg = resImg;
        this.imgText = imgText;
    }

    public int getResImg() {
        return resImg;
    }

    public void setResImg(int resImg) {
        this.resImg = resImg;
    }

    public String getImgText() {
        return imgText;
    }

    public void setImgText(String imgText) {
        this.imgText = imgText;
    }
}
