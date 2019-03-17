package com.onisq.phez;

public class Theme {
    private String name;
    private int img;


    public Theme(){}
    public Theme(String name, int img){
        this.name = name;
        this.img = img;
    }

    //Getter

    public String getName() {
        return name;
    }

    public int getImg() {
        return img;
    }

    //Setter


    public void setName(String name) {
        this.name = name;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
