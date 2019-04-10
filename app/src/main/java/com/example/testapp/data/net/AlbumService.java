package com.example.testapp.data.net;

import com.example.testapp.data.model.PictureDetails;

import java.util.List;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import retrofit2.Call;
import retrofit2.http.GET;


public interface AlbumService {
    @GET("/img/shared/technical-test.json")
    Call<List<PictureDetails>> getAlbum();
}
