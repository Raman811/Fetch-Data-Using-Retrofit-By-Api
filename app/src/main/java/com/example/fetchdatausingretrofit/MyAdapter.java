package com.example.fetchdatausingretrofit;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.fetchdatausingretrofit.Model.Data;
import com.example.fetchdatausingretrofit.Model.Feed_Images;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
private List<Data>data;
private List<Feed_Images>feed_images;
String url;


    private Context context;



    public MyAdapter(List<Data> list, Context applicationContext, String url) {
        this.data = list;
        this.context = applicationContext;
        this.url = url;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card,viewGroup, false);

        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int i) {
           myViewHolder.textView.setText(data.get(i).getViews());
           myViewHolder.like.setText(data.get(i).getLikes());
           myViewHolder.comment.setText(data.get(i).getComments());
           myViewHolder.bell.setText(data.get(i).getBells());
           myViewHolder.lorem.setText(data.get(i).getDescription());
           myViewHolder.thamson.setText(data.get(i).getUser().getUser_name());

        feed_images=data.get(i).getFeed_images();
        String s = feed_images.get(0).getImage();

//
//        String s  = feed_images.get(i).getImage();
        String ss = url+"/"+s;
        Glide.with(context).load(ss).into(myViewHolder.imageViewLeft);

        SharedPreferences sharedPreferences = context.getSharedPreferences("like",Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();
        final String s2;
        s2= "like"+data.get(i).getComments();
        String a1 = sharedPreferences.getString(s2,"2");
        myViewHolder.like.setText(a1);


        myViewHolder.lineari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String present_value_string = myViewHolder.like.getText().toString();
                int present_value_int = Integer.parseInt(present_value_string);
                present_value_int++;

                editor.putString(s2,String.valueOf(present_value_int));


             myViewHolder.like.setText(String.valueOf(present_value_int));
             editor.commit();

//
//                SharedPreferences sharedPreferences = context.getSharedPreferences(s1,Context.MODE_PRIVATE);
//                String string = sharedPreferences.getString("like","present_value_int");
//                SharedPreferences.Editor editor = sharedPreferences.edit();
//                editor.putString("string",present_value_int+string+"");
//                editor.apply();

//                private void saveFile(){
//                    String strName = editName.getText().toString();
//                    SharedPreferences sharedPref = getSharedPreferences(FileName, Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPref.edit();
//                    editor.putString("name",strName);
//                    editor.commit();
//                    Toast.makeText(this,"Data saved successfully", Toast.LENGTH_SHORT).show();
//                }
            }
        });
//        String s;
//        s = feed.get(i).getImage();
//        String ss = url+"/"+s;
//        Glide.with(context).load(ss).into(myViewHolder.imageView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView,like,comment,bell,lorem,thamson;
        ImageView imageViewLeft,likeimg;
        LinearLayout lineari;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.view);
            like = itemView.findViewById(R.id.like);
            comment = itemView.findViewById(R.id.comment);
            lineari = itemView.findViewById(R.id.likei);
            likeimg = itemView.findViewById(R.id.likeimg);
            imageViewLeft = itemView.findViewById(R.id.image_view_left);
            bell = itemView.findViewById(R.id.bell);
            lorem = itemView.findViewById(R.id.lorem);
            thamson = itemView.findViewById(R.id.thampson);

        }
    }
}
