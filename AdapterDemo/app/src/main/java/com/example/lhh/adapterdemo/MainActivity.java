package com.example.lhh.adapterdemo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private String[] names = new String[]{"暗影萨满", "撼地神牛", "众神之王",
                                            "极寒幽魂", "风暴之灵", "恶魔巫师",
                                            "火女", "复仇之魂", "水晶室女"};
    // "大酒神", "ZSMJ", "PIS", "Zhou", "YYF", "430", "820", "Burning", "Xiao8", "Nada"

    private List<String> LstName = new ArrayList<>(Arrays.asList(
            "暗影萨满", "撼地神牛", "众神之王",
            "极寒幽魂", "风暴之灵", "恶魔巫师",
            "火女", "复仇之魂", "水晶室女"));

    private List<String> LstMsg = Arrays.asList(
            "Don't worry, be happy. 别担心，开心点",
            "Justice will be served! 公正终将得以伸张",
            "I must feast on souls. 欢迎参加这场灵魂的盛宴",
            "Fall like the leaves, in fall. 像秋天的叶子般凋零吧",
            "The calm, before the storm. 暴风雨前的宁静",
            "I live to serve all believers. 我为服务信徒而生",
            "Time is short, mortal. 凡人，你的时间不多了",
            "I hear the call of the wild. 我听到了大自然的呼唤",
            "Future is ours. 未来是我们的");

    private List<Integer> LstIcon= Arrays.asList(
            R.mipmap.xy, R.mipmap.es, R.mipmap.zs,
            R.mipmap.aa, R.mipmap.lm, R.mipmap.lion,
            R.mipmap.lina, R.mipmap.vs, R.mipmap.cm);

    private String[] msgs = new String[]{
            "Don't worry, be happy. 别担心，开心点",
            "Justice will be served! 公正终将得以伸张",
            "I must feast on souls. 欢迎参加这场灵魂的盛宴",
            "Fall like the leaves, in fall. 像秋天的叶子般凋零吧",
            "The calm, before the storm. 暴风雨前的宁静",
            "I live to serve all believers. 我为服务信徒而生",
            "Time is short, mortal. 凡人，你的时间不多了",
            "I hear the call of the wild. 我听到了大自然的呼唤",
            "Future is ours. 未来是我们的"};

    private Integer[] imgs = new Integer[]{R.mipmap.xy, R.mipmap.es, R.mipmap.zs,
                                    R.mipmap.aa, R.mipmap.lm, R.mipmap.lion,
                                    R.mipmap.lina, R.mipmap.vs, R.mipmap.cm};

    // list_item.xml里的控件
    private String[] list_item_name = new String[]{"img_head", "list_name", "list_msg"};
    private int[] list_item_id = new int[]{R.id.img_head, R.id.list_name, R.id.list_msg};


    private List<Hero> mHeroLst = null;
    private Context mContext;
    private HeroAdapter mHeroAdapter = null;
    private ListView list_hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
////[1]
//        String[] strs = {"大酒神", "PIS", "YYF", "430", "Burning", "Xiao8", "Nada"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>
//                (this, android.R.layout.simple_list_item_1, strs);
//        ListView list_view = (ListView) findViewById(R.id.list_dota);
//        list_view.setAdapter(adapter);
////[1]


//        // [2]
//        List<Map<String, Object>> LstItem = new ArrayList<Map<String, Object>>();
//
//        for (int iIndex = 0; iIndex < names.length; ++iIndex){
//
//            Map<String, Object> showItem = new HashMap<String, Object>();
//            showItem.put("img_head", imgs[iIndex]);
//            showItem.put("list_name", names[iIndex]);
//            showItem.put("list_msg", msgs[iIndex]);
//
//            LstItem.add(showItem);
//        }
//
//        // 创建一个simpleAdapter
//        SimpleAdapter newAdapter = new SimpleAdapter(
//                getApplicationContext(),
//                LstItem,
//                R.layout.list_item,
//                list_item_name,
//                list_item_id);
//
//        // 创建一个ListView
//        ListView listView = (ListView) findViewById(R.id.list_dota);
//        listView.setAdapter(newAdapter);
//        // [2]

        // [3]
        mContext = MainActivity.this;
        list_hero = (ListView) findViewById(R.id.list_dota);
        mHeroLst = new LinkedList<Hero>();

        mHeroLst.add(new Hero(LstName, LstMsg, LstIcon));
        mHeroAdapter = new HeroAdapter((LinkedList<Hero>) mHeroLst, mContext);
        list_hero.setAdapter(mHeroAdapter);
        // [3]

    }

}
