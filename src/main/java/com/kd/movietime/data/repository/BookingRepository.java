package com.kd.movietime.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kd.movietime.data.entity.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
