package com.example.fetchdatausingretrofit.rest;

import com.example.fetchdatausingretrofit.Model.Info;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    String BASE_URL = "http://112.196.33.92/erin/api/";

    //http://112.196.33.92/erin/api/feeds/list?user_id=48&category_id=1

    @GET("feeds/list?user_id=48&category_id=1")
    Call<Info> CALL();

}
