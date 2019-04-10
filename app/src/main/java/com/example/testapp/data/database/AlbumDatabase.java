package com.example.testapp.data.database;

import android.content.Context;

import com.example.testapp.data.model.PictureDetails;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {PictureDetails.class}, version = 1, exportSchema = false)
public abstract class AlbumDatabase extends RoomDatabase {
    private static AlbumDatabase INSTANCE;

    public abstract AlbumDao AlbumDao();

    public static AlbumDatabase getAlbumDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE =
                    Room.databaseBuilder(context.getApplicationContext(), AlbumDatabase.class, "album")
                            .allowMainThreadQueries()
                            .build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
