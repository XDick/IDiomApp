package com.example.administrator.havingdate;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2018/3/16.
 */

public class FamousPeople extends DataSupport {
    private String title;
    private String  imageUrl;
    private  String pre;
    private String content;

    public FamousPeople(String title, String pre , String imageUrl, String content){
        this.title =title;
        this.pre= pre;
        this.imageUrl = imageUrl;
        this.content = content;
    }
    public FamousPeople(){}

    public String getImageId() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }
    public String getBody(){ return pre; }
    public String getContent(){return content;}

}
