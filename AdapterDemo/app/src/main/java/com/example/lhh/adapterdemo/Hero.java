package com.example.lhh.adapterdemo;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by lhh on 2017/11/7.
 */
public class Hero {
    private String strName;
    private String strSpeak;
    private int iIcon;

    private List<String> mLstName;
    private List<String> mLstSpeak;
    private List<Integer> mLstIcon;

    public Hero(){

    }

//    public Hero(String strName, String strSpeak, int iIcon){
//        this.strName = strName;
//        this.strSpeak = strSpeak;
//        this.iIcon = iIcon;
//    }

    public Hero(List<String> LstName, List<String> LstSpeak, List<Integer> LstIcon){
        this.mLstName = LstName;
        this.mLstSpeak = LstSpeak;
        this.mLstIcon = LstIcon;
    }

    public void setName(String strName){
        this.strName = strName;
    }
    public void setLstName(List<String> LstName){
        this.mLstName = LstName;
    }

    public void setSpeak(String strSpeak){
        this.strSpeak = strSpeak;
    }
    public void setLstSpeak(List<String> LstSpeak){
        this.mLstSpeak = LstSpeak;
    }

    public void setIcon(int iIcon){
        this.iIcon = iIcon;
    }
    public void setLstIcon(List<Integer> LstIcon){
        this.mLstIcon = LstIcon;
    }

    public String getName(){
        return strName;
    }
    public List<String> getLstName(){return mLstName;}

    public String getSpeak(){
        return strSpeak;
    }
    public List<String> getLstSpeak(){return mLstSpeak;}

    public int getIcon(){
        return iIcon;
    }
    public List<Integer> getLstIcon(){return mLstIcon;}
}
