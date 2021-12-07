package com.neo.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.neo.demo.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
//
//	@Query("select u from User u where u.firstName=:firstName or u.lastName=:lastName or u.pincode=:pincode")
//	List<User> findByfirstNameOrlastNameOrpincode(@Param("firstName") String firsName,
//			@Param("lastName") String lastName,@Param("pincode") String pincode);
//	
	
	
	List<User> findByfirstName(String firstName);
}
