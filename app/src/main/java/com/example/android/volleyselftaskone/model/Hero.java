package com.example.android.volleyselftaskone.model;

public class Hero {

    String mName;
    String mImageUrl;

    public Hero(String name, String imageUrl){
        this.mName = name;
        this.mImageUrl = imageUrl;
    }

    public String getImage() {
        return mName;
    }

    public void setImage(String mImage) {
        this.mName = mImage;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String mImageUrl) {
        this.mImageUrl = mImageUrl;
    }
}
