package com.example.fetchdatausingretrofit.Model;

import com.google.gson.annotations.SerializedName;

public class Feed_Images {

    @SerializedName("image")
    private String image;


    public Feed_Images(String image) {
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
