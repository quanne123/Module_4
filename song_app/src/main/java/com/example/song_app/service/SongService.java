package com.example.song_app.service;

import com.example.song_app.model.Song;
import com.example.song_app.repository.ISongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService{
    @Autowired
    private ISongRepository songRepository;
    @Override
    public List<Song> showAll() {
        return songRepository.findAll();
    }

    @Override
    public void createSong(Song song) {
        songRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return songRepository.getById(id);
    }

    @Override
    public void updateSong(Song song) {
        songRepository.save(song);
    }
}
