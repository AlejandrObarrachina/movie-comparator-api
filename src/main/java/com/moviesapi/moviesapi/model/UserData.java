package com.moviesapi.moviesapi.model;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "logginInfo")

public class UserData {
    @Id
    private String id;
    private String username;
    private String password;
}
