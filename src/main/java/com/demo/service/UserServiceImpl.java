package com.demo.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demo.Exception.CustomException;
import com.demo.dao.UserRepository;
import com.demo.entity.User;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepository;

	@Override
	public List<User> getAllUsers() {
		List<User> list = null;
		try {
			list = userrepository.findAll();
			if (list == null) {
				throw new CustomException("User not found");
			}

		} catch (CustomException ce) {
			ce.getMessage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;

	}

	@Override
	public User getUserById(long id) {
		User user = null;
		try {
			user = userrepository.findById(id);
			if (user == null) {
				throw new CustomException("User not found for id " + id);
			}

		} catch (CustomException ce) {
			log.error("CustomException occurred while fetching the data {}",ce.getMessage());
		} catch (Exception e) {
			log.error("Exception occurred while fetching the data {}",e.getMessage());
		}
		return user;

	}

	public User addUser(User user) {

		User u = userrepository.save(user);
		return u;

	}

	@Override
	public User deleteUser(long id) {

		userrepository.deleteById(id);

		return null;
	}

	@Override
	public User updateUser(long id, String name) {

		User user = userrepository.findById(id);
		user.setName(name);
		return userrepository.save(user);
	}

}
