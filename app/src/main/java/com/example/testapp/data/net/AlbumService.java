package com.example.testapp.data.net;

import com.example.testapp.data.model.PictureDetails;

import java.util.List;


import retrofit2.Call;
import retrofit2.http.GET;


public interface AlbumService {
    //service web to recover the pictures list
    @GET("/img/shared/technical-test.json")
    Call<List<PictureDetails>> getAlbum();
}
