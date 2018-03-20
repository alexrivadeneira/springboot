package com.example.testingspringbootmonolith.controllers;

import com.example.testingspringbootmonolith.models.Song;
import com.example.testingspringbootmonolith.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class SongsController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/songs")
    public Iterable<Song> findAllSongs(){
        return songRepository.findAll();
    }

    @GetMapping("/songs/{songId}")
    public Optional<Song> findSongById(@PathVariable Long songId){
        return songRepository.findById(songId);
    }

    @DeleteMapping("/songs/{songId}")
    public HttpStatus deleteSongById(@PathVariable Long songId){
        songRepository.deleteById(songId);
        return HttpStatus.OK;
    }

    @PostMapping("/songs")
    public Song addSong(@RequestBody Song newSong){
        return songRepository.save(newSong);
    }

    @PatchMapping("/songs/{songId}")
    public Song updateSong(@PathVariable Long songId, @RequestBody Song updatedSong){
        Song songToUpdate = songRepository.findById(songId).get();

        songToUpdate.setTitle(updatedSong.getTitle());
        songToUpdate.setSonglength(updatedSong.getSonglength());

        return songRepository.save(songToUpdate);
    }
}
