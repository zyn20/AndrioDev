package com.example.bscssectionabatch20.RestAPIExample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofitConnection {

    public static Retrofit retrofit=null;
    public static String URL = "https://jsonplaceholder.typicode.com/";
    public static Retrofit getMyRetrofit()
    {
        if(retrofit ==null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
