package com.kd.movietime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kd.movietime.data.entity.Movie;
import com.kd.movietime.data.repository.MovieRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepo;

	public List<Movie> getAllMovies() {

		return movieRepo.findAll();
	}

	public Movie getMovieById(Integer movieId) {

		return movieRepo.findById(movieId).orElse(null);
	}

	public void createMovie(Movie movie) {

		movieRepo.save(movie);
	}

	public void updateMovie(Integer movieId, Movie movie) {

		Movie existingMovie = movieRepo.findById(movieId).orElse(null);

		if (existingMovie == null) {
			throw new EntityNotFoundException("Could not find movie with id: " + movieId);
		}

		movieRepo.save(existingMovie);
	}

	public void deleteMovie(Integer movieId) {

		movieRepo.deleteById(movieId);
	}

}
