package com.example.bscssectionabatch20.RestAPIExample;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MyRetrofitInter {
    //fetching the data from server

    @GET("posts")
    Call<List<MyPostModel>> getPost();

    @GET("posts/1/comments")
    Call<List<MyPostModel>> getComments();

    @GET("posts/{id}/comments")
    Call<List<MyCommentsModel>> getAllCommentsByID(@Path("id")int id);

    @GET("comments")
    Call<List<MyCommentsModel>> getMyCommentsByQuery(@Query("postid") int id);

@GET("comments")
    Call<List<MyCommentsModel>> getCommentsByQuery2(@Query("postid") int id,
                                                    @Query("_sort") String sort,
                                                    @Query("_order")String orderby);
@POST("posts")
    Call<MyPostModel> createPost(@Body MyPostModel post);



}
