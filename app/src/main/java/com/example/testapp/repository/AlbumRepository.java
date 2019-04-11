package com.example.testapp.repository;



import android.content.Context;
import android.util.Log;

import com.example.testapp.data.database.AlbumDao;
import com.example.testapp.data.database.AlbumDatabase;
import com.example.testapp.data.model.PictureDetails;
import com.example.testapp.data.net.AlbumService;
import com.example.testapp.data.net.RetrofitClient;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import retrofit2.Response;

@Singleton
public class AlbumRepository {

    private final AlbumService albumService;
    private final AlbumDao albumDao;


    @Inject
    public AlbumRepository(Context context) {
        //initialize retrofit client
        this.albumService = RetrofitClient.getRetrofitInstance().create(AlbumService.class);
        //initialize albumDao
        this.albumDao = AlbumDatabase.getAlbumDatabase(context).AlbumDao() ;

    }

    public LiveData<List<PictureDetails>> getAlbum() {
        //refresh album from  service web
        refreshAlbum();
        // Returns a LiveData object directly from the database.
        return albumDao.load();
    }

    private void refreshAlbum() {
        // Runs in a background thread.
        new Thread(new Runnable() {
            @Override
            public void run() {
                Response<List<PictureDetails>> response = null;

                    try {
                        //call service web
                        response = albumService.getAlbum().execute();
                    } catch (IOException e) {
                        e.printStackTrace();

                    }

                    // Check for errors here.

                    // Updates the database. The LiveData object automatically
                    // refreshes, so we don't need to do anything else here.
                    albumDao.save(response.body());
                }


        }) .start();


    }


}
