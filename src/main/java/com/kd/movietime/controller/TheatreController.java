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

import com.kd.movietime.data.entity.Show;
import com.kd.movietime.data.entity.Theatre;
import com.kd.movietime.service.TheatreService;

@RestController
@RequestMapping("/api/v1/theatres")
public class TheatreController {

	@Autowired
	private TheatreService service;

	@GetMapping
	public ResponseEntity<List<Theatre>> getAllTheatres() {

		return ResponseEntity.ok(service.getAllTheatres());
	}

	@GetMapping("/{theatreId}")
	public ResponseEntity<Theatre> getTheatreById(@PathVariable Integer theatreId) {

		Theatre theatre = service.getTheatreById(theatreId);
		return buildResponseBody(theatre);
	}

	@PostMapping
	public ResponseEntity<Void> createTheatre(@RequestBody Theatre theatre) {

		service.createTheatre(theatre);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{theatreId}")
	public ResponseEntity<Void> updateTheatre(@PathVariable Integer theatreId, @RequestBody Theatre theatre) {

		service.updateTheatre(theatreId, theatre);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{theatreId}")
	public ResponseEntity<Void> deleteTheatre(@PathVariable Integer theatreId) {

		service.deleteTheatre(theatreId);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/{theatreId}/shows")
	public ResponseEntity<Void> addShows(@PathVariable Integer theatreId, @RequestBody List<Show> shows) {

		service.addShows(theatreId, shows);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{theatreId}/shows")
	public ResponseEntity<Void> updateShows(@PathVariable Integer theatreId, @RequestBody List<Show> shows) {

		service.updateShows(theatreId, shows);
		return ResponseEntity.ok().build();
	}

}
