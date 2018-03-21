package com.example.asuspc.medmyths.Adapter;

/**
 * Created by asus pc on 21/03/2018.
 */

public class MedicalInfo {
    public String title;
    public int medImage;

    public MedicalInfo(){}

    public MedicalInfo(String title, int medImage){
        this.title = title;
        this.medImage = medImage;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(){
        this.title = title;
    }

    public int getMedImage(){
        return medImage;
    }

    public void setMedImage(){
        this.medImage = medImage;
    }


}
