package com.example.administrator.havingdate;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.litepal.tablemanager.Connector;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2018/3/19.
 */

public class DownloadActivity extends Activity {

int size;
    ProgressBar  bar;
    TextView textView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.download_dialog_layout);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setFinishOnTouchOutside(false);
        Connector.getDatabase();

        Button button = findViewById(R.id.download_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getHtmlFromJsoup();
            }
        });

      bar= (ProgressBar) findViewById(R.id.progressBar);
       textView= (TextView) findViewById(R.id.percent_text);
       bar.setProgress(0);






    }

    private void getHtmlFromJsoup() {





        new Thread(new Runnable() {
            @Override
            public void run() {
                try {

             /*       for(int k=1;k<999;k++){
                        Document document = Jsoup.
                                connect("http://www.gs5000.cn/gs/chengyu/list_5_" + k + ".html")
                                .timeout(50000).get();

                        Elements sizeElements = document.getElementsByClass("preview");

                        size=size+sizeElements.size();

                        if(sizeElements.size()<10){break;}

                        System.out.print("加载完毕第"+sizeElements+"页");

                    }

                    System.out.print("加载完毕，成语有"+size+"个");*/







                   for (int j = 1; j <= 999; j++) {
                        Document document = Jsoup.
                                connect("http://www.gs5000.cn/gs/chengyu/list_5_" + j + ".html")
                                .timeout(50000).get();

                        Elements titleElements = document.getElementsByClass("title");
                        Elements bodyElements = document.getElementsByClass("intro");
                        Elements imgElements = document.getElementsByClass("preview");
                        Elements sizeElements = document.getElementsByClass("preview");
                        Elements contentElements = document.getElementsByClass("preview");


                        Log.d(TAG, "title:" + titleElements
                                .select("a").text());
                        Log.d(TAG, bodyElements.text());
                        Log.d(TAG, "pic:" + "http://www.gs5000.cn" + imgElements.select("img").attr("src"));
                        Log.d(TAG, "content:" + "http://www.gs5000.cn" + contentElements.select("a").attr("href"));


                        for (int i = 0; i < (sizeElements.size()); i++) {
                            Document document2 = Jsoup.
                                    connect("http://www.gs5000.cn"
                                            + contentElements.get(i).attr("href"))
                                    .timeout(0).get();
                                   size = size+ sizeElements.size();
                            Elements contentElements2 = document2.getElementsByClass("content");
                            Idiom idioms = new Idiom(titleElements.get(i + 1)
                                    .select("a").text(), bodyElements.get(i).text()
                                    , "http://www.gs5000.cn" + imgElements.get(i)
                                    .select("img")
                                    .attr("src")
                                    , contentElements2.select("table").text());
                            idioms.save();
                            System.out.print("size"+sizeElements.size());
                            bar.setProgress(size/841);
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText(size / 841 + "%");
                                }
                            });

                            if (sizeElements.size() < 10) {
                                break;
                            }

                        }

                    }
                    Log.d(TAG, "加载完毕！");

                } catch (Exception e) {
                    e.printStackTrace();
                    Log.d(TAG, "访问网络失败了！");


                }

            }
        }).start();

    }


}