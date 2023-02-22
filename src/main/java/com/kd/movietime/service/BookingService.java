package com.kd.movietime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kd.movietime.data.entity.Booking;
import com.kd.movietime.data.entity.Movie;
import com.kd.movietime.data.entity.Show;
import com.kd.movietime.data.entity.User;
import com.kd.movietime.data.repository.BookingRepository;
import com.kd.movietime.data.repository.ShowRepository;
import com.kd.movietime.data.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ShowRepository showRepo;

	public List<Booking> getAllBookings() {

		return bookingRepo.findAll();
	}

	public Booking getBookingById(Integer bookingId) {

		return bookingRepo.findById(bookingId).orElse(null);
	}

	public String createBooking(Booking booking) {

		String confirmationMsg = "";

		Show show = showRepo.findById(booking.getShow().getShowId()).orElseThrow();
		Double amount = booking.getSeats().size() * show.getPrice();
		booking.setAmount(amount);
		bookingRepo.save(booking);

		User user = userRepo.findById(booking.getUser().getUserId()).orElseThrow();
		Movie movie = show.getMovie();

		confirmationMsg = "Dear " + user.getFirstName() + ", your ticket(s) for movie " + movie.getName() + " for "
				+ show.getDateTime() + " are confirmed.";

		return confirmationMsg;
	}

	public void updateBooking(Integer bookingId, Booking booking) {

		Booking existingBooking = bookingRepo.findById(bookingId).orElse(null);

		if (existingBooking == null) {
			throw new EntityNotFoundException("Could not find booking with id: " + bookingId);
		}

		bookingRepo.save(existingBooking);
	}

	public void deleteBooking(Integer bookingId) {

		bookingRepo.deleteById(bookingId);
	}

}
