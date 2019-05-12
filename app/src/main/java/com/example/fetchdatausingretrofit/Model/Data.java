package com.example.fetchdatausingretrofit.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("title")
    private String title;

    @SerializedName("user")
    private User user;

    @SerializedName("feed_images")
    private List<Feed_Images>feed_images;

    @SerializedName("views")
    private String views;

    @SerializedName("likes")
    private String likes;

    @SerializedName("comments")
    private String comments;

    @SerializedName("bells")
    private String bells;

    @SerializedName("description")
    private String description;

    public Data(String title, User user, List<Feed_Images> feed_images, String views, String likes, String comments, String bells, String description) {
        this.title = title;
        this.user = user;
        this.feed_images = feed_images;
        this.views = views;
        this.likes = likes;
        this.comments = comments;
        this.bells = bells;
        this.description = description;
    }

    public String getBells() {
        return bells;
    }

    public void setBells(String bells) {
        this.bells = bells;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Feed_Images> getFeed_images() {
        return feed_images;
    }

    public void setFeed_images(List<Feed_Images> feed_images) {
        this.feed_images = feed_images;
    }
}
