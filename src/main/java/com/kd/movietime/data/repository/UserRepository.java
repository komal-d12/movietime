package com.kd.movietime.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kd.movietime.data.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
