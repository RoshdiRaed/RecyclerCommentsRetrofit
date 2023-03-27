package com.example.recyclercommentsretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<Comments> commentsArrayList;
    private String BASE_URL = "https://jsonplaceholder.typicode.com";
    MyApi api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.recyclerView);
        commentsArrayList = new ArrayList<>();


        viewJsonData();

    }

    private void viewJsonData() {
        //        create retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(MyApi.class);
        Call<ArrayList<Comments>> arrayListCall = api.modelColl();
        arrayListCall.enqueue(new Callback<ArrayList<Comments>>() {
            @Override
            public void onResponse(Call<ArrayList<Comments>> call, Response<ArrayList<Comments>> response) {
                commentsArrayList = response.body();
                for (int i = 0; i < commentsArrayList.size(); i++) {
                    MyAdapter ma = new MyAdapter(MainActivity.this,commentsArrayList);
                    RecyclerView.LayoutManager lm = new LinearLayoutManager(MainActivity.this);
                    rv.setLayoutManager(lm);
                    rv.setAdapter(ma);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<Comments>> call, Throwable t) {

            }
        });

    }
    }
