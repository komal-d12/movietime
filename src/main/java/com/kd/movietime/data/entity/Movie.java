package com.kd.movietime.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(schema = "movietime")
@Entity(name = "movie")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

	@Id
	@GeneratedValue
	private Integer movieId;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String cast;

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = String.join(", ", cast);
	}

}
