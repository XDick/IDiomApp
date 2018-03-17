package com.example.administrator.havingdate;

/**
 * Created by Administrator on 2017/9/16 0016.
 */

public class Information {
    private String name;
    private int imageId;
    public Information(String name, int imageId){
        this.name =name;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    public String getName() {
        return name;
    }
}
