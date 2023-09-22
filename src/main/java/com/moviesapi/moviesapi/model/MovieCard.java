package com.moviesapi.moviesapi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieCard {
    @Id
    private String id;
    private String original_title;
    private String poster_path;
    private String overview;
    private List<Genre> genres;
}
