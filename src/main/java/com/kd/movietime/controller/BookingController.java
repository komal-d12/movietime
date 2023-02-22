package com.kd.movietime.controller;

import static com.kd.movietime.util.Utils.buildResponseBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kd.movietime.data.entity.Booking;
import com.kd.movietime.service.BookingService;

@RestController
@RequestMapping("/api/v1/bookings")
public class BookingController {

	@Autowired
	private BookingService service;

	@GetMapping
	public ResponseEntity<List<Booking>> getAllBookings() {

		return ResponseEntity.ok(service.getAllBookings());
	}

	@GetMapping("/{bookingId}")
	public ResponseEntity<Booking> getBookingById(@PathVariable Integer bookingId) {

		Booking booking = service.getBookingById(bookingId);
		return buildResponseBody(booking);
	}

	@PostMapping
	public ResponseEntity<String> createBooking(@RequestBody Booking booking) {

		return ResponseEntity.ok(service.createBooking(booking));
	}

}
