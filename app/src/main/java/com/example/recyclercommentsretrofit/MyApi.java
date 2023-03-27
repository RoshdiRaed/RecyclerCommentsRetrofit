package com.example.recyclercommentsretrofit;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApi {
    @GET("comments")
    Call<ArrayList<Comments>> modelColl();

}
