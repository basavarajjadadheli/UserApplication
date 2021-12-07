package com.neo.demo.service;





import java.util.List;
import java.util.Optional;

import com.neo.demo.entity.User;

public interface UserService {
	
	public User addUser(User user);

	public User updateById(int UserId,User user);
	
	public Optional<User> findUserById(int UserID);
	
//	public List<User> findByfirstNameOrlastNameOrpincode(String firstName,String lastName,String pincode);

	public List<User> findUserByfirstName(String firstName);
	
	public List<User> SortByDateofJoinAndDateofBirth();
	
	public String userSoftDelete(int userId);
}
