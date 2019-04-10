package com.example.testapp.data.net;

import retrofit2.Retrofit;

public class RetrofitClient {
    static String BASE_URL="https://static.leboncoin.fr";
    static Retrofit retrofitInstance =null;
    public  static Retrofit getRetrofitInstance(){
        if(retrofitInstance==null){
             retrofitInstance= new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .build();
        }
        return retrofitInstance;

    }

}
