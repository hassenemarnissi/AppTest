package com.example.testapp;



import android.os.Bundle;
import com.example.testapp.adapter.AlbumAdapter;
import com.example.testapp.data.model.PictureDetails;
import com.example.testapp.viewmodel.AlbumViewModel;


import java.util.List;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class MainActivity extends AppCompatActivity {
    private AlbumViewModel albumViewModel;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //instance the ViewModel
        albumViewModel = ViewModelProviders.of(this).get(AlbumViewModel.class);
        //initialize the ViewModel with data
        albumViewModel.init(getApplicationContext());
        //the observer will recover the data and set the recyclerView
        albumViewModel.getAlbum().observe(this, new Observer<List<PictureDetails>>() {

            @Override
            public void onChanged(@Nullable List<PictureDetails> album) {
                mRecyclerView = findViewById(R.id.rvAlbum);
                GridLayoutManager mGridLayoutManager = new GridLayoutManager(MainActivity.this, 2);
                mRecyclerView.setLayoutManager(mGridLayoutManager);
                AlbumAdapter albumAdapter = new AlbumAdapter(MainActivity.this, album);
                mRecyclerView.setAdapter(albumAdapter);

            }
        });
    }
}

