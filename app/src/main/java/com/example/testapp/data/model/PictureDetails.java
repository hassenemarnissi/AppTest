package com.example.testapp.data.model;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "album")
public class PictureDetails {

        @PrimaryKey
        private int id;//id of picture
        private int albumId ;// album id
        private String title;// title of picture
        private String url;//url of best quality picture
        private String thumbnailUrl;// url of picture will be used as the preview image

        public int getId() {
                return id;
        }

        public void setId(int id) {
                this.id = id;
        }

        public int getAlbumId() {
                return albumId;
        }

        public void setAlbumId(int albumId) {
                this.albumId = albumId;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getUrl() {
                return url;
        }

        public void setUrl(String url) {
                this.url = url;
        }

        public String getThumbnailUrl() {
                return thumbnailUrl;
        }

        public void setThumbnailUrl(String thumbnailUrl) {
                this.thumbnailUrl = thumbnailUrl;
        }




}
