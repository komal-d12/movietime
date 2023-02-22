package com.kd.movietime.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kd.movietime.data.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

}
