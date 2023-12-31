package com.example.cgrmovies.controller;

import com.example.cgrmovies.model.Genre;
import com.example.cgrmovies.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class GenreController {

    private GenreService genreService;

    static HashMap<String, Object> message = new HashMap<>();

    /**
     * Sets the genre service.
     */
    @Autowired
    public void setGenreService(GenreService genreService) {
        this.genreService = genreService;
    }

    /**
     * Creates a new genre.
     *
     * @param  genre  the genre object to be created
     * @return        a ResponseEntity containing a message and the newly created genre
     */
    @PostMapping(path = "/genres/")
    public ResponseEntity<?> createGenre(@RequestBody Genre genre) {
        Genre newGenre = genreService.createGenre(genre);
        if (newGenre != null) {
            message.put("message", "Genre created successfully");
            message.put("data", newGenre);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        } else {
            message.put("message", "Cannot create genre");
            return new ResponseEntity<>(message, HttpStatus.CONFLICT);
        }
    }

    /**
     * Retrieves all genres from the API.
     *
     * @return  A ResponseEntity object containing the genre list and a message indicating success or failure.
     */
    @GetMapping(path = "/genres/")
    public ResponseEntity<?> getAllGenres() {
        List<Genre> genreList = genreService.getAllGenres();
        if (genreList != null) {
            message.put("message", "Genre list retrieved");
            message.put("data", genreList);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } else {
            message.put("message", "Cannot retrieve genre list");
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }
    }
}
