package com.example.fetchdatausingretrofit.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Info {

    @SerializedName("status")
    private String status;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    List<Data> data;

    @SerializedName("feed_image_path")
    private String feed_image_path;

    public Info(String status, String message, List<Data> data, String feed_image_path) {
        this.status = status;
        this.message = message;
        this.data = data;
        this.feed_image_path = feed_image_path;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Data> getData() {
        return data;
    }

    public void setData(List<Data> data) {
        this.data = data;
    }

    public String getFeed_image_path() {
        return feed_image_path;
    }

    public void setFeed_image_path(String feed_image_path) {
        this.feed_image_path = feed_image_path;
    }
}
