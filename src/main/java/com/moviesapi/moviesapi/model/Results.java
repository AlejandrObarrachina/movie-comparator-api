package com.moviesapi.moviesapi.model;

import lombok.Data;

import java.util.List;

@Data
public class Results {
    private List<MovieCard> results;
}
