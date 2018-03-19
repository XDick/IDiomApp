package com.example.administrator.havingdate;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Administrator on 2017/10/1 0001.
 */

public class Activity2 extends Fragment {


    private SwipeRefreshLayout swipeRefresh;

   private  Document document2;
   private  Document document;
    private List<Idiom> idiomList = new ArrayList<>();
    private  Idiom[] idiomArry;
    private IdiomAdapter adapter;
    private Elements sizeElements;
    private int ListSize;
    private View rootView;//缓存Fragment view
    boolean notFinish =true;




    /*--------------------------------------------------------*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if(rootView==null) {
            rootView = inflater.inflate(R.layout.fragment_layout2, container, false);
        }
       //缓存的rootView需要判断是否已经被加过parent， 如果有parent需要从parent删除，要不然会发生这个rootview已经有parent的错误。

            ViewGroup parent = (ViewGroup) rootView.getParent();

            if (parent != null) {

                parent.removeView(rootView);
            }

    Log.d(TAG,"看看有没有运行");


/*------------------------------------数据库储存-----------------------*/

          initIdioms();

/*-----------------------------列表--------------------------------------*/
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new IdiomAdapter(idiomList);
        recyclerView.setAdapter(adapter);
        Log.d(TAG,"列表生成的代码");

        swipeRefresh = (SwipeRefreshLayout) rootView.findViewById(R.id.swipe_refresh);
        swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshInformations();
            }
        });




        return rootView;
    }
    /*--------------------------实现刷新功能---------------------------*/

    private void refreshInformations() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                ((AppCompatActivity) getActivity()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initIdioms();
                        Toast.makeText(getContext(), "刷新成功", Toast.LENGTH_SHORT).show();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }
    /*------------------------------------------------------------------------*/







/*--------------------------Jsoup爬虫--------------------------------------------------*/






    private void initIdioms() {
        idiomList.clear();
        List<Idiom> idiomData = new ArrayList<Idiom>();
        idiomData = DataSupport.limit(1000).offset(0).find(Idiom.class);
        Collections.shuffle(idiomData);//使列表乱序
        for (Idiom idiom: idiomData){

            idiomList.add(idiom);
            Log.d(TAG , idiom.getTitle());
        }
        ListSize = idiomData.size();
        Log.d(TAG , "列表大小"+ListSize);

   }
    }
