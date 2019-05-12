package com.example.fetchdatausingretrofit;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.fetchdatausingretrofit.Model.Data;
import com.example.fetchdatausingretrofit.Model.Feed_Images;
import com.example.fetchdatausingretrofit.Model.Info;
import com.example.fetchdatausingretrofit.rest.ApiClient;
import com.example.fetchdatausingretrofit.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Data> list;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Info> call = apiService.CALL();
        call.enqueue(new Callback<Info>() {
            @Override
            public void onResponse(Call<Info> call, Response<Info> response) {


                list = response.body().getData();
//               list1 = response.body().getFeed_image_path();


//
//                assert response.body() != null;
                MyAdapter myAdapter = new MyAdapter(list,getApplicationContext(),response.body().getFeed_image_path());
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
                recyclerView.setAdapter(myAdapter);
            }

            @Override
            public void onFailure(Call<Info> call, Throwable t) {

            }
        });
    }
}
