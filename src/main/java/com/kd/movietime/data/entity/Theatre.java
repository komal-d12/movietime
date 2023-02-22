package com.kd.movietime.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Table(schema = "movietime")
@Entity(name = "theatre")
@Data
public class Theatre {

	@Id
	@GeneratedValue
	private Integer theatreId;

	/*
	@OneToMany(mappedBy = "showId", cascade = CascadeType.ALL)
	private List<Show> movieShows;
	*/

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String city;

	public Integer getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(Integer theatreId) {
		this.theatreId = theatreId;
	}

	/*
	public List<Show> getMovieShows() {
		return movieShows;
	}

	public void setMovieShows(List<Show> movieShows) {
		this.movieShows = movieShows;
	}
	*/

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
