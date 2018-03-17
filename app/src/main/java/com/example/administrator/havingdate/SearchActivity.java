package com.example.administrator.havingdate;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.litepal.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/9/27 0027.
 */

public class SearchActivity extends AppCompatActivity {
    TextView responseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        responseText =findViewById(R.id.response_text);
        sendRequestWithOkHttp();
    }




    private void sendRequestWithOkHttp(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder()
                            .url("http://xdick.top").build();
                    Response response = client.newCall(request).execute();
                   String responseDate = response.body().string();
                    Document document = Jsoup.parse(responseDate);
                    List<Element> titleElementList = new ArrayList<>();
                    Elements titleElements = document.getElementsByClass("post-title-link");
                    for (final Element element : titleElements) {
                        titleElementList.add(element);

                    }

                        List<Element> timeElementList = new ArrayList<>();
                        Elements timeElements = document.getElementsByClass("post-time");
                        for (Element element : timeElements) {
                            //LogUtil.d("time=" + element.getElementsByTag("time").text());
                            timeElementList.add(element);
                        }
                        //Elements categoryElements = document.getElementsByClass("post-category");
                        //for (Element element : categoryElements) {
                        //    LogUtil.d("category=" + element.getElementsByTag("a").text());
                        //}


                        List<Element> bodyElementList = new ArrayList<>();
                        Elements bodyElements = document.getElementsByClass("post-body");
                        for (Element element : bodyElements) {
                            bodyElementList.add(element);




                }
                }
                catch(Exception e){
                    e.printStackTrace();

                }
            }
        }).start();

    }


    private void showResponse(final String response){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                responseText.setText(response);
            }
        });

    }
}
