package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.User;
import com.example.repository.UserRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
	@GetMapping("/users")
	public List<User> getUsers(){
		return userRepository.findAll();
	}
	
	@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id){
		return userRepository.findOne(id);
	}
	
	@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
	@DeleteMapping("/user/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		userRepository.delete(id);
		return true;
	}
	
//	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
//	@ResponseBody
	
//	@PostMapping("/user")
	@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
	@PostMapping(path = "/user", consumes = "application/json", produces = "application/json")
	public User createUser(@RequestBody User user){
		return userRepository.save(user);
	}
	
//	@PutMapping("/user")
	@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
	@PutMapping(path = "/user", consumes = "application/json", produces = "application/json")
	public User updateUser(@RequestBody User user){
		return userRepository.save(user);
	}
	
	

}
