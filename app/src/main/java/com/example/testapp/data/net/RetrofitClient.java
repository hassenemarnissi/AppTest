package com.example.testapp.data.net;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    static String BASE_URL="https://static.leboncoin.fr";
    static Retrofit retrofitInstance =null;
    public  static Retrofit getRetrofitInstance(){
        if(retrofitInstance==null){
             retrofitInstance= new Retrofit.Builder()
                     .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofitInstance;

    }

}
