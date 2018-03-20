package com.example.testingspringbootmonolith.controllers;

import com.example.testingspringbootmonolith.models.Song;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongsController {
    public Iterable<Song> findAllSongs(){
        return new Iterable<Song>;
    }
}
