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

import com.kd.movietime.data.entity.User;
import com.kd.movietime.service.UserService;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {

		return ResponseEntity.ok(service.getAllUsers());
	}

	@GetMapping("/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Integer userId) {

		User user = service.getUserById(userId);
		return buildResponseBody(user);
	}

	@PostMapping
	public ResponseEntity<Void> createUser(@RequestBody User user) {

		service.createUser(user);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{userId}")
	public ResponseEntity<Void> updateUser(@PathVariable Integer userId, @RequestBody User user) {

		service.updateUser(userId, user);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable Integer userId) {

		service.deleteUser(userId);
		return ResponseEntity.ok().build();
	}

}
