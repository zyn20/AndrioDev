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