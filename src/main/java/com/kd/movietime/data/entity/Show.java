package com.kd.movietime.data.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Table(schema = "movietime")
@Entity(name = "show_details")
@Data
public class Show {

	@Id
	@GeneratedValue
	private Integer showId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "theatreId")
	private Theatre theatre;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "movieId")
	private Movie movie;

	@Column(nullable = false)
	private LocalDateTime dateTime;

	@Column(nullable = false)
	private Double price;

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
