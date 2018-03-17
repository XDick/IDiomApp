package com.example.administrator.havingdate;

import android.net.Uri;

import org.litepal.crud.DataSupport;

import java.net.URL;

/**
 * Created by Administrator on 2018/3/11.
 */

public class Idiom extends DataSupport {
    private String title;
    private String  imageUrl;
    private  String pre;
    private String content;

    public Idiom(String title, String pre , String imageUrl,String content){
        this.title =title;
        this.pre= pre;


       this.imageUrl = imageUrl;

       this.content = content;
    }
    public Idiom(){}

    public String getImageId() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }
    public String getBody(){ return pre; }
    public String getContent(){return content;}




}
