package com.example.administrator.havingdate;

import org.litepal.crud.DataSupport;

/**
 * Created by Administrator on 2017/10/6 0006.
 */

public class User extends DataSupport{
    private String id;

    private String password;


public String getId(){
        return id;
    }


    public void setId(String id){
        this.id= id;

    }

    public String getPassword(){
        return password;
    }


    public void setPssword(String password){
      this.password= password;

    }



}
