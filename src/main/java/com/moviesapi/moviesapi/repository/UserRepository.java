package com.moviesapi.moviesapi.repository;

import com.moviesapi.moviesapi.model.UserData;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<UserData, String> {
    List<UserData> findAll();
}