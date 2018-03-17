package com.example.administrator.havingdate;

import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.view.ViewPager.OnPageChangeListener;


import org.litepal.tablemanager.Connector;
import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.RunnableFuture;
import android.support.v4.view.PagerAdapter;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabReselectListener;
import com.roughike.bottombar.OnTabSelectListener;

public class FirstActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;



    private BottomBar bottomBar;

    private BottomBarTab nearby;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        Connector.getDatabase();


       /*---------------------------------悬浮按钮--------------------------------*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
       /*--------------------------------------------------------*/
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        View headview = navView.inflateHeaderView(R.layout.nav_header);

        /*------------------------------------------------*/
        navView.setCheckedItem(R.id.nav_Logation);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_Logation:
                        Intent intent1 = new Intent(FirstActivity.this, AuthorActivity.class);
                        startActivity(intent1);
                        break;
                    case R.id.nav_author:
                        Intent intent2 = new Intent(FirstActivity.this, AuthorActivity.class);
                        startActivity(intent2);
                        break;
                    case R.id.nav_about:
                        Intent intent3 = new Intent(FirstActivity.this, AuthorActivity.class);
                        startActivity(intent3);
                        break;

                }

                mDrawerLayout.closeDrawers();

                return true;
            }
        });

/*----------------------------------登录功能----------------------------------------*/

        headview.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View view){
            Intent intent = new Intent(FirstActivity.this, EnterActivity.class);
                startActivity(intent);
            }


        });


        /*---------------------底部导航栏----------------------------------*/

        //replaceFragment(new Activity2());

        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.bottom_main:
                        nearby = bottomBar.getTabWithId(R.id.bottom_main);
                                                         /*nearby.setBadgeCount(5);*/
                        replaceFragment(new Activity2());

                        break;
                    case R.id.bottom_food:
                        nearby = bottomBar.getTabWithId(R.id.bottom_food);
                        replaceFragment(new Activity1());
                        break;
                    case R.id.bottom_more:
                        nearby = bottomBar.getTabWithId(R.id.bottom_more);

                        replaceFragment(new Activity3());
                        break;
                    case R.id.bottom_setting:
                        nearby = bottomBar.getTabWithId(R.id.bottom_setting);

                        replaceFragment(new Activity4());
                        break;
                    default:
                        break;
                }
            }
        });
        bottomBar.setOnTabReselectListener(new OnTabReselectListener() {
            @Override
            public void onTabReSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.bottom_main:
                        nearby.removeBadge();
                        break;
                    case R.id.bottom_food:
                        nearby.removeBadge();
                        break;
                    case R.id.bottom_more:
                        nearby.removeBadge();
                        break;
                    case R.id.bottom_setting:
                        nearby.removeBadge();
                        break;
                    default:
                        break;
                }
            }
        });



    /*-------------------------------------------------------------*/

    /*---------------------------------------------------------------------------*/
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.menu);
        }

    }

    /*--------------------------------------------------------------------------------------*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
        case android.R.id.home:
        mDrawerLayout.openDrawer(GravityCompat.START);
        break;
            case  R.id.search:
                Intent intent1 = new Intent(FirstActivity.this,SearchActivity.class);
                startActivity(intent1);
          break;}
        return true;

    }

    /*--------------------------------------------------------------------------------------*/
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.toolbar,menu);

        return true;
    }

/*-------------------------------------显示碎片-------------------------------------------------*/



private void replaceFragment (Fragment fragment){
    FragmentManager fragmentManager = getSupportFragmentManager();
    FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.replace(R.id.fragment,fragment);
    transaction.commit();

}
    /*------------------------------------得到碎片----------------------------------------------*/
    /*public Fragment getVisibleFragment(){
        FragmentManager fragmentManager = FirstActivity.this.getSupportFragmentManager();
        List<Fragment> fragments = fragmentManager.getFragments();
        for(Fragment fragment : fragments){
            if(fragment != null && fragment.isVisible())
                return fragment;
        }
        return null;
    }
*/
}
