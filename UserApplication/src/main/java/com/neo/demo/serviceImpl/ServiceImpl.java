package com.neo.demo.serviceImpl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neo.demo.dao.UserRepository;
import com.neo.demo.entity.User;
import com.neo.demo.service.UserService;

@Service
public class ServiceImpl implements UserService {

	@Autowired
	private UserRepository  repository;
	
	// register new user with so many field along with validation 
     @Override
	public User addUser(User user) {
		 return repository.save(user);
	}

	//update or Edit User base on user id 
     @Override
	public User updateById(int UserId,User user) {
		User userdb=repository.findById(UserId).get();
		if(userdb!=null) {
			userdb.setFirstName(user.getFirstName());
			userdb.setLastName(user.getLastName());
			userdb.setDateOfJoining(user.getDateOfJoining());
			userdb.setDateofBirth(user.getDateofBirth());
			userdb.setEmail(user.getEmail());
			userdb.setAdress(user.getAdress());
			userdb.setPincode(user.getPincode());
			}
		
		return repository.save(userdb);
	}
	
     

//	//Search User by Name or Surname or Pincode 
//	@Override
//	public List<User> findByfirstNameOrlastNameOrpincode(String firstName, String lastName, String pincode) {
//	return repository.findByfirstNameOrlastNameOrpincode(firstName, lastName, pincode);	}

    // Sort User by DOB & Joining Date 
    @Override
	public List<User> SortByDateofJoinAndDateofBirth() {
	List<User> userdb=repository.findAll();
	List<User> sortedUser=userdb.stream().
				sorted(Comparator.comparing(User::getDateofBirth)
				.thenComparing(User::getDateOfJoining)).collect(Collectors.toList());
		return sortedUser;
	}

    //Soft & Hard Delete User, 
      @Override
	public String userSoftDelete(int userId) {
		 repository.deleteById(userId);
		return "user deleted ";
	}

	@Override
	public Optional<User> findUserById(int UserID) {
		return repository.findById(UserID);}

	@Override
	public List<User> findUserByfirstName(String firstName) {
		return repository.findByfirstName(firstName); }

	

}

