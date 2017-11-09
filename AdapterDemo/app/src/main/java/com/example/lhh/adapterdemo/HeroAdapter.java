package com.example.lhh.adapterdemo;

import android.content.ContentValues;
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

//    public View getView(int position, View convertView, ViewGroup parent){
//        convertView = LayoutInflater.from(mcontext).inflate(R.layout.list_item, parent, false);
//        ImageView img_hero = (ImageView) convertView.findViewById(R.id.img_head);
//        TextView txt_name = (TextView) convertView.findViewById(R.id.list_name);
//        TextView txt_speak = (TextView) convertView.findViewById(R.id.list_msg);
//
//        img_hero.setBackgroundResource(mHeroLst.get(position).getIcon());
//        txt_name.setText(mHeroLst.get(position).getName());
//        txt_speak.setText(mHeroLst.get(position).getSpeak());
//
//        return convertView;
//    }

    /**BaseAdapter优化
     * 1.复用convertView
     * 2.ViewHolder重用组件
     * */
    public View getView(int position, View convertView, ViewGroup parent){

        ViewHolder holder = null;

        if (null == convertView){
            convertView = LayoutInflater.from(mcontext).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder();
            holder.img_hero = (ImageView) convertView.findViewById(R.id.img_head);
            holder.txt_name = (TextView) convertView.findViewById(R.id.list_name);
            holder.txt_speak = (TextView) convertView.findViewById(R.id.list_msg);

            convertView.setTag(holder);
        }
        else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.img_hero.setBackgroundResource(mHeroLst.get(position).getIcon());
        holder.txt_name.setText(mHeroLst.get(position).getName());
        holder.txt_speak.setText(mHeroLst.get(position).getSpeak());

        return convertView;
    }

    static class ViewHolder{
        ImageView img_hero;
        TextView txt_name;
        TextView txt_speak;
    }

    /**
     * @author by lhh
     * @brief 在列表最后添加一条数据
     * @param hero
     * @return void
     * */
    public void AddRow(Hero hero){

        if (null == mHeroLst){
            mHeroLst = new LinkedList<>();
        }

        mHeroLst.add(hero);
        notifyDataSetChanged();
    }

    /**
     * @author by lhh
     * @brief 在指定位置添加一条数据
     * @param hero
     * @return void
     * */
    public void InsertRow(int position, Hero hero){

        if (null == mHeroLst){
            mHeroLst = new LinkedList<>();
        }

        mHeroLst.add(position, hero);
        notifyDataSetChanged();
    }

    /**
     * @author by lhh
     * @brief 按对象删除某一条数据
     * @param hero
     * @return void
     * */
    public void DelRowByObject(Hero hero){

        if (null != mHeroLst){
            mHeroLst.remove(hero);
        }

        notifyDataSetChanged();
    }

    /**
     * @author by lhh
     * @brief 按对象删除某一条数据
     * @param position
     * @return void
     * */
    public void DelRowByPos(int position){

        if (null != mHeroLst){
            mHeroLst.remove(position);
        }

        notifyDataSetChanged();
    }



}
