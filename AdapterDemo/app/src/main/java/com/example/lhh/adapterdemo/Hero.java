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

//    private List<String> mLstName;
//    private List<String> mLstSpeak;
//    private List<Integer> mLstIcon;

    public Hero(){

    }

    public Hero(String strName, String strSpeak, int iIcon){
        this.strName = strName;
        this.strSpeak = strSpeak;
        this.iIcon = iIcon;
    }

    public void setName(String strName){
        this.strName = strName;
    }

    public void setSpeak(String strSpeak){
        this.strSpeak = strSpeak;
    }

    public void setIcon(int iIcon){
        this.iIcon = iIcon;
    }

    public String getName(){
        return strName;
    }

    public String getSpeak(){
        return strSpeak;
    }

    public int getIcon(){
        return iIcon;
    }
}
