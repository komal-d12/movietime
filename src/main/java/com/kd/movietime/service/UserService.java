package com.kd.movietime.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kd.movietime.data.entity.User;
import com.kd.movietime.data.repository.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> getAllUsers() {

		return userRepo.findAll();
	}

	public User getUserById(Integer userId) {

		return userRepo.findById(userId).orElse(null);
	}

	public void createUser(User user) {

		userRepo.save(user);
	}

	public void updateUser(Integer userId, User user) {

		User existingUser = userRepo.findById(userId).orElse(null);

		if (existingUser == null) {
			throw new EntityNotFoundException("Could not find user with id: " + userId);
		}

		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setAddress(user.getAddress());
		existingUser.setCity(user.getCity());
		existingUser.setMobile(user.getMobile());
		existingUser.setEmail(user.getEmail());
		userRepo.save(existingUser);
	}

	public void deleteUser(Integer userId) {

		userRepo.deleteById(userId);
	}

}
