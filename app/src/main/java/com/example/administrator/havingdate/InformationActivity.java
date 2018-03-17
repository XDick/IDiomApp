package com.example.administrator.havingdate;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by Administrator on 2017/9/19 0019.
 */

public class InformationActivity extends AppCompatActivity{
    public static final String INFORMATION_NAME="information_name";

    public static final String INFORMATION_IMAGE_ID="information_image_id";

@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_information);


    Intent intent =getIntent();
    String informationName = intent.getStringExtra(INFORMATION_NAME);
    int informationImageId = intent.getIntExtra(INFORMATION_IMAGE_ID,0);
    String articleImageUrl = intent.getStringExtra("image_url");

    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout)
            findViewById(R.id.collapsing_toolbar);
    ImageView informationImageView = (ImageView)findViewById(R.id.information_image_view);
    TextView informationContentText = (TextView) findViewById(R.id.information_content_text);
    setSupportActionBar(toolbar);
    ActionBar actionBar = getSupportActionBar();
    if(actionBar !=null){
        actionBar.setDisplayHomeAsUpEnabled(true);
    }
    collapsingToolbar.setTitle(informationName);
    Glide.with(this).load(informationImageId).into(informationImageView);
    Glide.with(this).load(articleImageUrl).into(informationImageView);
    String informationContent = generateInformationContent(informationName);
    informationContentText.setText(informationContent);

    }

    private String generateInformationContent(String informationName){
        StringBuilder informationContent = new StringBuilder();
            switch (informationName){
               case "圣鲸国际美食百汇":
                   informationContent.append("营业时间：周一至周日 11:00-14:30 16:30-21:00\n" +
                        "门店风格：浪漫小资\n" +
                        "门店服务： 支持WIFI 停车位收费标准：自律停车\n" +
                        "门店介绍：\n" +
                        "圣鲸国际美食百汇地处黄金地段，位置优越，交通便利，是将各式多元化美食融合一身的复合式自助餐厅，以“烹制百千珍馐精华，汇集天下美食”为主题，百余种美食云集荟萃，为春城食客奉上美食盛宴。\n" +
                        "消费评价:服务还可以。海螃蟹虽然是速冻的，但是大部分很新鲜，肉很足，母蟹新鲜，个别公蟹不怎么样。刺身新鲜好吃，特别推荐深海金枪鱼，好像是，就是三文鱼边上白色的鱼肉。牛排很嫩。大虾新鲜。饮料、水果、其他小食都不错。种类丰富。对了，看别桌领取的活河蟹很新鲜，因为吃不动了所以没领。要特别向管理者提个建议，希望你们看到后能重视：吃后有一点拉肚子，不是很严重。蒸锅是熟的，刺身也很新鲜，食材本身应该问题不大。能否在刀具、菜板、摆放刺身的托盘、寿司直接摆在冰上、切菜人员个人，等等，这些细节的卫生方面再下功夫，定时清洗、消毒、更换，或再增加一些防护，会更好一些！总之，各方面质量标准不低，达到中档以上水平，这个价位能吃到这么多美食，现在的圣鲸非常棒！还会再来！希望再接再厉！"
                   );
                   break;
                case "宴遇时尚餐厅":
                    informationContent.append("营业时间：周一至周日 10:30-03:00\n" +
                            "门店风格：随便吃吃\n" +
                            "门店服务： 支持WIFI 商家服务：停车位收费标准：自律\n" +
                            "门店介绍：\n" +
                            "宴遇时尚餐厅让你享受世间浪漫的事情，莫过于无意间的邂逅，出乎意料又令人惊喜万分。古人称这种经历为“艳遇”，即遇见美好—美人、美景，当然还有美酒、美食。越忙碌，越奔波，就越需这些美好的瞬间来添资生活、愉悦自我。\n"
                    +"这个口味我只想说真的不好吃，有点牛奶炖柿子的味道，里面都是西红柿，没有麻辣的口感，而是酸溜溜的，加的香菜煮太久了都黑乎乎的了，我真的不知道这是怎样的一个厨师做的菜，茄子拌的还可以，菜品整体都很咸啊，然后点了个秋葵切成一小片片的，我第一次吃这样的秋葵，秋葵的口感和味道已经完全没有了，图片是我临走时拍的，几乎没怎么吃，真的都不好吃，第一次吃饭给这样的差评，还有那个水果树非常不推荐，感觉很脏，那个架子一定不好刷而且水果应该是用手穿上去的吧，完全没有食欲，两个人团了78的团购，外点55，吃的很失败");
                    break;
                case "麒麟大虾":
                    informationContent.append("营业时间：周一至周日 10:30-03:00\n" +
                            "门店风格：随便吃吃\n" +
                            "门店服务： 支持WIFI 商家服务：停车位收费标准：自律\n" +
                            "门店介绍：\n" +
                            "宴遇时尚餐厅让你享受世间浪漫的事情，莫过于无意间的邂逅，出乎意料又令人惊喜万分。古人称这种经历为“艳遇”，即遇见美好—美人、美景，当然还有美酒、美食。越忙碌，越奔波，就越需这些美好的瞬间来添资生活、愉悦自我。\n"
                            +"这个口味我只想说真的不好吃，有点牛奶炖柿子的味道，里面都是西红柿，没有麻辣的口感，而是酸溜溜的，加的香菜煮太久了都黑乎乎的了，我真的不知道这是怎样的一个厨师做的菜，茄子拌的还可以，菜品整体都很咸啊，然后点了个秋葵切成一小片片的，我第一次吃这样的秋葵，秋葵的口感和味道已经完全没有了，图片是我临走时拍的，几乎没怎么吃，真的都不好吃，第一次吃饭给这样的差评，还有那个水果树非常不推荐，感觉很脏，那个架子一定不好刷而且水果应该是用手穿上去的吧，完全没有食欲，两个人团了78的团购，外点55，吃的很失败");
                default:
                    informationContent.append(getIntent().getStringExtra("idiom_content"));

                    break;
            }

            return informationContent.toString();
    }


@Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

