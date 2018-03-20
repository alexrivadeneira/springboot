package com.example.testingspringbootmonolith.controllers;

import com.example.testingspringbootmonolith.models.Song;
import com.example.testingspringbootmonolith.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongsController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/songs")
    public Iterable<Song> findAllSongs(){
        return songRepository.findAll();
    }
}
