package com.example.testapp;


import android.os.Bundle;
import android.widget.Toast;

import com.example.testapp.data.model.PictureDetails;

import com.example.testapp.viewmodel.AlbumViewModel;


import java.util.List;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProviders;


public class MainActivity extends AppCompatActivity {
    private AlbumViewModel albumViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel.class);
        albumViewModel.init(getApplicationContext());
        albumViewModel.getAlbum().observe(this, new Observer<List<PictureDetails>>() {

            @Override
            public void onChanged(@Nullable List<PictureDetails> album) {

               // Toast.makeText(getApplicationContext(),album.get(0).toString(),Toast.LENGTH_LONG);
            }
        });
    }
}

