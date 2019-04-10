package com.example.testapp.viewmodel;




import android.content.Context;

import com.example.testapp.data.model.PictureDetails;
import com.example.testapp.repository.AlbumRepository;

import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class AlbumViewModel extends ViewModel {
    private LiveData<List<PictureDetails>> album;
    private AlbumRepository albumRepository;

    // Instructs Dagger 2 to provide the AlbumViewModel parameter.
    @Inject
    public AlbumViewModel() {

    }

    public void init(Context context) {
        this.albumRepository=new AlbumRepository(context);
        if (this.album != null) {

            return;
        }
        album = albumRepository.getAlbum();
    }

    public LiveData<List<PictureDetails>> getAlbum() {
        return this.album;
    }
}