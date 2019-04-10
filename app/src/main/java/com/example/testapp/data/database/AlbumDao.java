package com.example.testapp.data.database;




import com.example.testapp.data.model.PictureDetails;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface AlbumDao {
    @Insert(onConflict = REPLACE)
    void save(List<PictureDetails> album);
    @Query("SELECT * FROM album ")
    LiveData<List<PictureDetails>> load();
}
