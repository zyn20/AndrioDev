package com.example.bscssectionabatch20.RestAPIExample;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyRetrofitInter {
    //fetching the data from server

    @GET("posts")
    Call<List<MyPostModel>> getPost();

    @GET("posts/{id}/comments")
    Call<List<MyPostModel>> getComments(@Path("id")int id);




}
