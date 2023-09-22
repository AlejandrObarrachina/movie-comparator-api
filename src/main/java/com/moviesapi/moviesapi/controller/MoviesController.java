package com.moviesapi.moviesapi.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moviesapi.moviesapi.model.MovieCard;
import com.moviesapi.moviesapi.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MoviesController {
    private final MoviesService service;

    public MoviesController(MoviesService service) {
        this.service = service;
    }

    @GetMapping( value = "/movies", produces = { "application/json"})
    private List<MovieCard> getAllMovies() throws JsonProcessingException {
        return service.getAllMovies();
    }
    @GetMapping( value = "/get-movie-by-id/{id}", produces = { "application/json"})
    private MovieCard getMovieById(@PathVariable String id) throws JsonProcessingException {
        return service.getMovieById(id);
    }

    @GetMapping( value = "/movies/{genre}", produces = { "application/json"})
    private ResponseEntity<List<MovieCard>> getMoviesByGenre(@PathVariable String genre) throws JsonProcessingException {
        return service.getMoviesByGenre(genre);
    }
}
