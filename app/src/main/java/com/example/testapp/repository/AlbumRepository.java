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
import java.util.concurrent.Executor;

import javax.inject.Inject;
import javax.inject.Singleton;

import androidx.lifecycle.LiveData;
import retrofit2.Response;

@Singleton
public class AlbumRepository {

    private final AlbumService albumService;
    private final AlbumDao albumDao;
   private Executor executor;

    @Inject
    public AlbumRepository(Context context) {
        this.albumService = RetrofitClient.getRetrofitInstance().create(AlbumService.class);
        this.albumDao = AlbumDatabase.getAlbumDatabase(context).AlbumDao() ;

    }

    public LiveData<List<PictureDetails>> getAlbum() {
        refreshUser();
        // Returns a LiveData object directly from the database.
        return albumDao.load();
    }

    private void refreshUser() {
        // Runs in a background thread.


        executor=new Executor() {
            @Override
            public void execute(Runnable command) {

            }
        };
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Response<List<PictureDetails>> response = null;
                try {
                    response = albumService.getAlbum().execute();
                    Log.d("dddddddd11", response.message());
                } catch (IOException e) {
                    e.printStackTrace();
                    Log.d("dddddddd11", e.toString());
                }

                // Check for errors here.

                // Updates the database. The LiveData object automatically
                // refreshes, so we don't need to do anything else here.
                albumDao.save(response.body());
            }
        })cd;
    }


}
