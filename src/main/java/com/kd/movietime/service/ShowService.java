package com.kd.movietime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kd.movietime.data.SearchCriteria;
import com.kd.movietime.data.entity.Movie;
import com.kd.movietime.data.entity.Show;
import com.kd.movietime.data.entity.Theatre;
import com.kd.movietime.data.repository.MovieRepository;
import com.kd.movietime.data.repository.ShowRepository;
import com.kd.movietime.data.repository.TheatreRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ShowService {

	@Autowired
	private ShowRepository showRepo;

	@Autowired
	private TheatreRepository theatreRepo;

	@Autowired
	private MovieRepository movieRepo;

	public List<Show> getAllShows() {

		return showRepo.findAll();
	}

	public Show getShowById(Integer showId) {

		return showRepo.findById(showId).orElse(null);
	}

	public void createOrUpdateShow(Show show) {

		// TODO: Temporary work-around for the 'detached entity' issue

		Theatre existingTheatre = null;
		Movie existingMovie = null;

		if (show.getTheatre().getTheatreId() != null) {
			existingTheatre = theatreRepo.findById(show.getTheatre().getTheatreId()).orElse(null);
			if (existingTheatre != null) {
				show.setTheatre(null);
			}
		}

		if (show.getMovie().getMovieId() != null) {
			existingMovie = movieRepo.findById(show.getMovie().getMovieId()).orElse(null);
			if (existingMovie != null) {
				show.setMovie(null);
			}
		}

		show = showRepo.save(show);

		if (existingTheatre != null) {
			show.setTheatre(existingTheatre);
		}

		if (existingMovie != null) {
			show.setMovie(existingMovie);
		}

		showRepo.save(show);
	}

	public void updateShow(Integer showId, Show show) {

		Show existingShow = showRepo.findById(showId).orElse(null);

		if (existingShow == null) {
			throw new EntityNotFoundException("Could not find show with id: " + showId);
		}

		showRepo.save(existingShow);
	}

	public void deleteShow(Integer showId) {

		showRepo.deleteById(showId);
	}

	public List<Show> searchShows(SearchCriteria criteria) {

		List<Show> shows = getAllShows();
		shows = shows.stream().filter(
				show -> (criteria.getDate() == null || show.getDateTime().toLocalDate().isEqual(criteria.getDate()))
						&& (criteria.getMovieId() == null || criteria.getMovieId().equals(show.getMovie().getMovieId()))
						&& (criteria.getCity() == null || criteria.getCity().equals(show.getTheatre().getCity())))
				.toList();

		return shows;

	}

}
