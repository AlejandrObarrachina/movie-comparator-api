package com.moviesapi.moviesapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moviesapi.moviesapi.model.MovieCard;
import com.moviesapi.moviesapi.model.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;


import java.util.List;


@Service
public class MoviesService {
    @Autowired
    private RestTemplate restTemplate;

    String api_key = "?api_key=" + System.getenv("API_KEY");

    public MovieCard getMovieById(@PathVariable String id) throws JsonProcessingException {
        String url = "https://api.themoviedb.org/3/movie/" + id + api_key;
        return restTemplate.getForObject(url, MovieCard.class);

    }

    public List<MovieCard> getAllMovies() throws JsonProcessingException {

        String url = "https://api.themoviedb.org/3/movie/popular" + api_key;
        Results response = restTemplate.getForObject(url, Results.class);
        assert response != null;
        return response.getResults();
    }

    public ResponseEntity<List<MovieCard>> getMoviesByGenre(String genre) {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin", "*");

        String url = "https://api.themoviedb.org/3/discover/movie"+ api_key+ "&language=en-US&with_genres=" + genre ;
        Results response = restTemplate.getForObject(url, Results.class);
        assert response != null;
        return ResponseEntity.ok().headers(responseHeaders).body(response.getResults());
    }
}
