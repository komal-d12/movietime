package com.kd.movietime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kd.movietime.data.entity.Show;
import com.kd.movietime.data.entity.Theatre;
import com.kd.movietime.data.repository.TheatreRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class TheatreService {

	@Autowired
	private ShowService showService;

	@Autowired
	private TheatreRepository theatreRepo;

	public List<Theatre> getAllTheatres() {

		return theatreRepo.findAll();
	}

	public Theatre getTheatreById(Integer theatreId) {

		return theatreRepo.findById(theatreId).orElse(null);
	}

	@Transactional
	public void createTheatre(Theatre theatre) {

		theatreRepo.save(theatre);
	}

	public void updateTheatre(Integer theatreId, Theatre theatre) {

		Theatre existingTheatre = theatreRepo.findById(theatreId).orElse(null);

		if (existingTheatre == null) {
			throw new EntityNotFoundException("Could not find theatre with id: " + theatreId);
		}

		existingTheatre.setName(theatre.getName());
		existingTheatre.setCity(theatre.getCity());
		theatreRepo.save(existingTheatre);
	}

	public void deleteTheatre(Integer theatreId) {

		theatreRepo.deleteById(theatreId);
	}

	public void addShows(Integer theatreId, List<Show> shows) {

		Theatre theatre = theatreRepo.findById(theatreId).orElseThrow();

		shows.stream().forEach(show -> {
			show.setTheatre(theatre);
			showService.createOrUpdateShow(show);
		});
	}

	public void updateShows(Integer theatreId, List<Show> shows) {

		Theatre theatre = theatreRepo.findById(theatreId).orElseThrow();

		shows.stream().forEach(show -> {
			show.setTheatre(theatre);
			showService.createOrUpdateShow(show);
		});
	}

}
