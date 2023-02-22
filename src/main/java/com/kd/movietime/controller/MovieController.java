package com.kd.movietime.controller;

import static com.kd.movietime.util.Utils.buildResponseBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kd.movietime.data.entity.Movie;
import com.kd.movietime.service.MovieService;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {

	@Autowired
	private MovieService service;

	@GetMapping
	public ResponseEntity<List<Movie>> getAllMovies() {

		return ResponseEntity.ok(service.getAllMovies());
	}

	@GetMapping("/{movieId}")
	public ResponseEntity<Movie> getMovieById(@PathVariable Integer movieId) {

		Movie movie = service.getMovieById(movieId);
		return buildResponseBody(movie);
	}

	@PostMapping
	public ResponseEntity<Void> createMovie(@RequestBody Movie movie) {

		service.createMovie(movie);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{movieId}")
	public ResponseEntity<Void> updateMovie(@PathVariable Integer movieId, @RequestBody Movie movie) {

		service.updateMovie(movieId, movie);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{movieId}")
	public ResponseEntity<Void> deleteMovie(@PathVariable Integer movieId) {

		service.deleteMovie(movieId);
		return ResponseEntity.ok().build();
	}

}
