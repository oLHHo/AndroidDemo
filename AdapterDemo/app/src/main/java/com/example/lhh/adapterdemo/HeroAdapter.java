package com.example.lhh.adapterdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by lhh on 2017/11/7.
 */
public class HeroAdapter extends BaseAdapter {
    private LinkedList<Hero> mHeroLst;
    private Context mcontext;

    public HeroAdapter(LinkedList<Hero> lstHero, Context context){
        this.mHeroLst = lstHero;
        this.mcontext = context;
    }


    public int getCount(){
        return mHeroLst.size();
    }

    public Object getItem(int position){
        return null;
    }

    public long getItemId(int position){
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        convertView = LayoutInflater.from(mcontext).inflate(R.layout.list_item, parent, false);
        ImageView img_hero = (ImageView) convertView.findViewById(R.id.img_head);
        TextView txt_name = (TextView) convertView.findViewById(R.id.list_name);
        TextView txt_speak = (TextView) convertView.findViewById(R.id.list_msg);

        img_hero.setBackgroundResource(mHeroLst.get(position).getIcon());
        txt_name.setText(mHeroLst.get(position).getName());
        txt_speak.setText(mHeroLst.get(position).getSpeak());

        return convertView;
    }
}
