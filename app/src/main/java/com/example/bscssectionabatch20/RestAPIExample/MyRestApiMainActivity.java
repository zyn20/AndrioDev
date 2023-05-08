package com.example.bscssectionabatch20.RestAPIExample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.bscssectionabatch20.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyRestApiMainActivity extends AppCompatActivity {

    MyRetrofitInter apiInterface;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_rest_api_main);
        recyclerView = findViewById(R.id.myrestrecyclerview);
        apiInterface=MyRetrofitConnection.getMyRetrofit().create(MyRetrofitInter.class);
        //GetAllPosts();
        //getAllComments();
        //getCommentsByID();
        //getCommentsByQuery();
        getCommentsByQuery2();
        CreatPost();
    }

    private void CreatPost() {
        MyPostModel postModel = new MyPostModel(10,5,"title of MY Post","Body of my Post");
        apiInterface.createPost(postModel);
        Call<MyPostModel> mypost = apiInterface.createPost(postModel);
        mypost.enqueue(new Callback<MyPostModel>() {
            @Override
            public void onResponse(Call<MyPostModel> call, Response<MyPostModel> response) {
                if(response.isSuccessful())
                {
                    Log.d("TAG","  " + response.body().getUserId()
                    + "\n" + response.body().getId()
                    + "\n" + response.body().getTitle());
                }
            }

            @Override
            public void onFailure(Call<MyPostModel> call, Throwable t) {

            }
        });
    }

    /*  private void getAllComments() {
          apiInterface.getComments().enqueue(new Callback<List<MyCommentsModel>>() {
              @Override
              public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                  if(response.body().size()>0)
                  {
                      for (MyCommentsModel myCommentsModel : response.body())
                      {
                          Log.d("Tag","ID = " + myCommentsModel.getId()+
                                  "Post ID"+myCommentsModel.getPostId()
                          +"Name " + myCommentsModel.getName()
                          +"Email" + myCommentsModel.getEmail())
                      }

                  }
              }
              @Override
              public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {


              }
          });
      }

     */
    private void getCommentsByID() {
        apiInterface.getAllCommentsByID(3).enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.body().size()>0)
                {
                    for (MyCommentsModel myCommentsModel : response.body())
                    {
                        Log.d("Tag","ID = " + myCommentsModel.getId()+
                                "Post ID"+myCommentsModel.getPostId()
                                +"Name " + myCommentsModel.getName()
                                +"Email" + myCommentsModel.getEmail());
                    }

                }
            }
            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {


            }
        });
    }
    private void getCommentsByQuery() {
        apiInterface.getMyCommentsByQuery(3).enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.body().size()>0)
                {
                    for (MyCommentsModel myCommentsModel : response.body())
                    {
                        Log.d("Tag","ID = " + myCommentsModel.getId()+
                                "Post ID"+myCommentsModel.getPostId()
                                +"Name " + myCommentsModel.getName()
                                +"Email" + myCommentsModel.getEmail());
                    }

                }
            }
            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {


            }
        });
    }
    private void getCommentsByQuery2() {
        apiInterface.getCommentsByQuery2(3,"id","desc").enqueue(new Callback<List<MyCommentsModel>>() {
            @Override
            public void onResponse(Call<List<MyCommentsModel>> call, Response<List<MyCommentsModel>> response) {
                if(response.body().size()>0)
                {
                    for (MyCommentsModel myCommentsModel : response.body())
                    {
                        Log.d("Tag","ID = " + myCommentsModel.getId()+
                                "Post ID"+myCommentsModel.getPostId()
                                +"Name " + myCommentsModel.getName()
                                +"Email" + myCommentsModel.getEmail());
                    }

                }
            }
            @Override
            public void onFailure(Call<List<MyCommentsModel>> call, Throwable t) {


            }
        });
    }

    private void GetAllPosts() {
        apiInterface.getPost().enqueue(new Callback<List<MyPostModel>>() {
            @Override
            public void onResponse(Call<List<MyPostModel>> call, Response<List<MyPostModel>> response) {
                if (response.body().size()>0)
                {
                    Log.d("Tag","Data Retrieved");
                    List<MyPostModel> list = response.body();
                    MyRestAdapter adapter = new MyRestAdapter(list,MyRestApiMainActivity.this);
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MyRestApiMainActivity.this);
                    recyclerView.setLayoutManager(linearLayoutManager);
                    recyclerView.setAdapter(adapter);

                }
                else {
                    Log.d("Tag","List is Empty");

                }
            }

            @Override
            public void onFailure(Call<List<MyPostModel>> call, Throwable t) {
                Log.d("Tag","Data Retrieval Failure");
            }
        });
    }

}