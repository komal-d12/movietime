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

import com.kd.movietime.data.SearchCriteria;
import com.kd.movietime.data.entity.Show;
import com.kd.movietime.service.ShowService;

@RestController
@RequestMapping("/api/v1/shows")
public class ShowController {

	@Autowired
	private ShowService service;

	@GetMapping
	public ResponseEntity<List<Show>> getAllShows() {

		return ResponseEntity.ok(service.getAllShows());
	}

	@GetMapping("/{showId}")
	public ResponseEntity<Show> getShowById(@PathVariable Integer showId) {

		Show show = service.getShowById(showId);
		return buildResponseBody(show);
	}

	@PostMapping
	public ResponseEntity<Void> createShow(@RequestBody Show show) {

		service.createOrUpdateShow(show);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{showId}")
	public ResponseEntity<Void> updateShow(@PathVariable Integer showId, @RequestBody Show show) {

		service.updateShow(showId, show);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{showId}")
	public ResponseEntity<Void> deleteShow(@PathVariable Integer showId) {

		service.deleteShow(showId);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/search")
	public ResponseEntity<List<Show>> searchShows(@RequestBody SearchCriteria criteria) {

		return ResponseEntity.ok(service.searchShows(criteria));
	}

}
