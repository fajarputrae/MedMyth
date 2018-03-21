package com.example.asuspc.medmyths.Adapter;

/**
 * Created by asus pc on 20/03/2018.
 */

public class GameMenu {
    private int angka;
    private int thumbnail;
    private String level;

    public GameMenu(){}

    public GameMenu(int angka, String level, int thumbnail){
        this.angka = angka;
        this.level = level;
        this.thumbnail = thumbnail;
    }

    public int getAngka(){
        return angka;
    }

    public void setAngka(){
        this.angka = angka;
    }

    public String getLevel(){
        return level;
    }

    public void setLevel(){
        this.level = level;
    }

    public int getThumbnail(){
        return thumbnail;
    }

    public void setThumbnail(){
        this.thumbnail = thumbnail;
    }


}
