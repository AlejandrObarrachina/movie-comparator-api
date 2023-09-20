package com.moviesapi.moviesapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieCard {
    private String id;
    private String original_title;
    private String backdrop_path;
    private String overview;
    private List<Genre> genres;
}