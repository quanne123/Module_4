package com.example.song_app.service;

import com.example.song_app.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> showAll();

    void createSong(Song song);

    Song findById(int id);

    void updateSong(Song song);
}
