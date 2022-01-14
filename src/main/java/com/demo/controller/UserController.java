package com.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;
import com.demo.service.UserService;
import com.demo.service.UserServiceImpl;

@RestController
public class UserController {
	@Autowired
	private UserService userservice;


	@GetMapping("/getAllUsers")
	public ResponseEntity< List<User>> getAllUsers() {
		List<User> lu = userservice.getAllUsers() ;
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(lu);
	}

	@GetMapping("/getUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		User uid = userservice.getUserById(id);
		return ResponseEntity.status(HttpStatus.OK).body(uid);
	}

	@PostMapping("/saveUser")
	public ResponseEntity<User>  addUser(@RequestBody User user) {
		User ud = userservice.addUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(ud);

	}

	@DeleteMapping("/deleteUser/{id}")
	public ResponseEntity<User>  deleteUser(@PathVariable("id") long id) {
		User did = userservice.deleteUser(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(did);

	}

	@PutMapping("/updateUser/{id}/{name}")
	public ResponseEntity<User> updateUser(@PathVariable long id,@PathVariable String name) {
		User upUser = userservice.updateUser(id, name);
		return ResponseEntity.status(HttpStatus.OK).body(upUser);
	}

}
