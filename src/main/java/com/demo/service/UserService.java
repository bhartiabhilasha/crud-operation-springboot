package com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.demo.entity.User;

public interface UserService {
	public  List<User> getAllUsers();

	public User getUserById(long id);

	public User addUser(User user);

	public User deleteUser(long id);

	public User updateUser(long id, String name);
}
