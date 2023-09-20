package com.moviesapi.moviesapi.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.moviesapi.moviesapi.model.MovieCard;
import com.moviesapi.moviesapi.model.Results;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Service
public class MoviesService {

    public MovieCard getMovieById(@PathVariable String id) throws JsonProcessingException {
        String url = "https://api.themoviedb.org/3/movie/" + id + "?api_key=b77a11d0c97e646dd927293a6b1ad43d";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, MovieCard.class);

    }

    public List<MovieCard> getAllMovies() throws JsonProcessingException {

        String url = "https://api.themoviedb.org/3/movie/popular" + "?api_key=b77a11d0c97e646dd927293a6b1ad43d";
        RestTemplate restTemplate = new RestTemplate();
        Results response = restTemplate.getForObject(url, Results.class);
        assert response != null;

        return response.getResults();
    }
}
