package com.example.wbdvsu1projectserverjava.services;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.wbdvsu1projectserverjava.models.User;
import com.example.wbdvsu1projectserverjava.repositories.UserRepository;


@CrossOrigin("*")
@RestController
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	
	
	@PostMapping("/api/register")
	public User createUser(@RequestBody User user, HttpSession session) {
		session.setAttribute("currUser", user);
		return userRepository.save(user);
	}
	
	@PostMapping("/api/login")
	public User login(@RequestBody User loginUser, HttpSession session) {
		System.out.println(loginUser.getUsername());
		List<User> users = (List<User>) this.findAllusers();
		for(User user : users) {
			if(user.getUsername().equals(loginUser.getUsername()) && user.getPassword().equals(loginUser.getPassword())) {
				session.setAttribute("currUser", user);
				return user;
			}
		}
		return null;
	}
	
	@GetMapping("/api/profile")
	public User profile(HttpSession session) {
		return (User)session.getAttribute("currUser");
	}
	
	@GetMapping("/api/users")
	public Iterable<User> findAllusers() {
		return userRepository.findAll();
	}
	
	@PostMapping("/api/logout")
	public void logout(HttpSession session) {
		session.invalidate();
	}
	
	@GetMapping("/api/user/{userId}")
	public User findUserById(
			@PathVariable("userId") Integer userId) {
		return userRepository.findById(userId).get();
	}
	
	@PutMapping("/api/user/{userId}")
	public @ResponseBody User updateUser(@PathVariable("userId") Integer id, @RequestBody User newUser, HttpSession session) {
		User user = userRepository.findById(id).get();
		user.setFirstName(newUser.getFirstName());
		user.setLastName(newUser.getLastName());
		user.setEmail(newUser.getEmail());
		user.setPhone(newUser.getPhone());
		user.setRole(newUser.getRole());
		System.out.println("AUTHORED UPDATE");
		session.setAttribute("currUser", user);
		userRepository.save(user);
		
		return user;
	}
	
	@DeleteMapping("/api/user/{userId}")
	public void deleteUser(@PathVariable("userId") Integer id) {
		User user = userRepository.findById(id).get();
		userRepository.delete(user);
		System.out.print("DELETERE");
	}
	
	
	

	
}
