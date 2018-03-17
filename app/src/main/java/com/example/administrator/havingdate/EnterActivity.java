package com.example.administrator.havingdate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Administrator on 2017/9/25 0025.
 */

public class EnterActivity extends AppCompatActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button enter;
    private Button sign;
    private User user;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_layout);

        accountEdit = (EditText)findViewById(R.id.enter_edit_view_account);
        passwordEdit = (EditText)findViewById(R.id.enter_edit_view_password);
        enter = (Button)findViewById(R.id.enter_button_enter);
        sign = (Button)findViewById(R.id.enter_button_sign);





        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                user = new User();
                user.setId(accountEdit.getText().toString());
                user.setPssword(passwordEdit.getText().toString());
                user.save();

            }
        });



        enter.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                if(account.equals(user.getId())&&password.equals(user.getPassword())){
                    Toast.makeText(EnterActivity.this, "登录成功",Toast.LENGTH_SHORT).show();
                    finish();
                }
                else{
                        Toast.makeText(EnterActivity.this, "你输入的帐号或密码有误",Toast.LENGTH_SHORT).show();
                    }
            }
        });



}


}
