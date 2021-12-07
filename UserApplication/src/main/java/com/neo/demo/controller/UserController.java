package com.neo.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neo.demo.entity.User;
import com.neo.demo.service.UserService;


@RestController
public class UserController {
	
	@Autowired
	private UserService userservice;
	

	
	@PostMapping("/newUser")
	public User saveUser(@Valid @RequestBody User user) { 
		return userservice.addUser(user);
	}
	
	@GetMapping("getById/{id}")
	public Optional<User> getUserById(@PathVariable("id") int UserId) {
		return userservice.findUserById(UserId);
	}
	
	
	@PostMapping("Updateuser/{id}")
	public User UpdateUser(@PathVariable("id") int UserId, @Valid @RequestBody User user) {
		return userservice.updateById(UserId, user);
	}

//	@GetMapping("getUser/{values}")
//	public List<User> fetchBylastNameOrpinCodeOrfirstName(@PathVariable("values") String firstName,
//			@PathVariable("values") String lastName,@PathVariable("values") String pincode){
//		return userservice.findByfirstNameOrlastNameOrpincode(firstName, lastName, pincode);
//	}
	
	@GetMapping("getByName/{name}")
	public List<User> getUseByfirstName(@PathVariable("name") String firstName) {
		return userservice.findUserByfirstName(firstName);
	}
	
	@GetMapping("/getAllUser")
	public List<User> SortByDateofJoinAndDateofBirth(){
		return userservice.SortByDateofJoinAndDateofBirth();
	}
	@DeleteMapping("softDelete/{id}")
	public String softDeleteUser(@PathVariable("id") int userId) {
		
		return userservice.userSoftDelete(userId);
	}

}
