package com.example.lhh.adapterdemo;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements AdapterView.OnItemClickListener, View.OnClickListener {

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


    private LinkedList<Hero> mLstHero = null;
    private Context mContext;
    private HeroAdapter mHeroAdapter = null;
    private ListView mLstView;
    private Button mAddBtn;
    private Button mInsertBtn;
    private Button mDelOBtn;
    private Button mDelPBtn;

    private int iFlag = 1;
    private int iCol = 3;

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
        mLstView = (ListView) findViewById(R.id.list_dota);
        mLstHero = new LinkedList<Hero>();

        for (int iIndex = 0; iIndex < LstName.size(); ++iIndex) {
            mLstHero.add(new Hero(LstName.get(iIndex), LstMsg.get(iIndex), LstIcon.get(iIndex)));
        }

        mHeroAdapter = new HeroAdapter((LinkedList<Hero>) mLstHero, mContext);
        mLstView.setAdapter(mHeroAdapter);
        mLstView.setOnItemClickListener(this);
        // [3]


        // 添加按钮
        mAddBtn = (Button) findViewById(R.id.add_btn);
        // 插入按钮
        mInsertBtn = (Button) findViewById(R.id.insert_btn);
        // 删除按钮（对象）
        mDelOBtn = (Button) findViewById(R.id.delO_btn);
        // 删除按钮（位置）
        mDelPBtn = (Button) findViewById(R.id.delP_btn);

        mAddBtn.setOnClickListener(this);
        mInsertBtn.setOnClickListener(this);
        mDelOBtn.setOnClickListener(this);
        mDelPBtn.setOnClickListener(this);

    }

    /**
     * @author by lhh
     * @brief 按钮点击事件
     * @param v
     * return void
     * */
    public void onClick(View v){
        switch (v.getId()){
            // 添加
            case R.id.add_btn:
                String strAddName = "魔兽Dota";
                mHeroAdapter.AddRow(new Hero(strAddName, "Don't Worry, Be Happy! 第" + iFlag + "个", R.mipmap.sjcp));
                LstName.add(strAddName + "第" + iFlag + "个");
                mHeroAdapter.refresh(mLstHero);
                //mHeroAdapter.clear();
                ++iFlag;

                int iSize = mLstView.getCount();
                Toast.makeText(mContext, "第"+iSize+"行添加：" + LstName.get(iSize - 1), Toast.LENGTH_SHORT).show();
                break;

            // 插入（第四行）
            case R.id.insert_btn:
                String strInsertNew = "Battery";
                mHeroAdapter.InsertRow(iCol, new Hero(strInsertNew, "Be Happy 第" + iFlag + "个", R.mipmap.hdcp));
                LstName.add(iCol, strInsertNew + "第" + iFlag + "个");
                mHeroAdapter.refresh(mLstHero);
                //mHeroAdapter.clear();
                ++iFlag;
                int iRow = iCol+1;
                Toast.makeText(mContext,"第"+iRow+"行插入：" + LstName.get(iCol), Toast.LENGTH_SHORT).show();
                break;

            // 根据对象删除
            case R.id.delO_btn:
                int iDRow = iCol+1;
                if (iCol < mLstView.getCount()){
                    mHeroAdapter.DelRowByObject(mLstHero.get(iCol));
                    mHeroAdapter.refresh(mLstHero);
                    //mHeroAdapter.clear();
                    Toast.makeText(mContext, "删除第"+iDRow+"行："+LstName.get(iCol), Toast.LENGTH_SHORT).show();
                    LstName.remove(iCol);

                    if (1 < iFlag){
                        --iFlag;
                    }

                }
                break;

            // 根据位置删除
            case R.id.delP_btn:
                int iDdRow = iCol+1;
                if (iCol < mLstView.getCount()){
                    mHeroAdapter.DelRowByPos(iCol);
                    mHeroAdapter.refresh(mLstHero);
                    //mHeroAdapter.clear();
                    Toast.makeText(mContext, "删除第"+iDdRow+"行："+LstName.get(iCol), Toast.LENGTH_SHORT).show();
                    LstName.remove(iCol);

                    if (1 < iFlag){
                        --iFlag;
                    }
                }
                break;

            default:
                break;
        }
    }

    /**
     * @author by lhh
     * @brief item点击事件
     * @param adapterView, View, position, id
     * return void
     * */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(mContext,"嗨，你好！我是" + LstName.get(position), Toast.LENGTH_SHORT).show();
        //Toast.makeText(mContext,"嗨，你好！我是" + position, Toast.LENGTH_SHORT).show();
    }

}
