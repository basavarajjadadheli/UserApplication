package com.neo.demo;




import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.demo.dao.UserRepository;
import com.neo.demo.entity.User;
import com.neo.demo.serviceImpl.ServiceImpl;




@SpringBootTest
@RunWith(SpringRunner.class)
class UserApplicationTests {

	@Autowired
	private ServiceImpl impl;
	
    @MockBean
	private UserRepository repo;
	
    @Test
    @Rollback(false)
    @Order(1)
    public void saveUserTest() {
		User user=User.builder()
				.firstName("ravi")
				.adress("Banglore")
				.email("raj@gmail.com")
				.UserId(1).build();
		impl.addUser(user);
		Assertions.assertThat(user.getUserId()).isGreaterThan(0);
    }    
    @Test
    @Rollback(false)
    @Order(1)
    public void getUserByIdTest() {
		User user=User.builder()
				.firstName("ravi")
				.adress("Banglore")
				.email("raj@gmail.com")
				.UserId(1).build();
		repo.save(user);
		assertNotNull(repo.findById(1).get());
    }    
 
    
    
    
    @Test
	public void getAllUserTest() {
		when(repo.findAll()).thenReturn(Stream
		.of(new User(1,"raj", "Jadadeli","11-01-2004","11-01-2006","basavarajjadadheli@gmail.com","Banglore", "560035",false),
				new User(2,"Basavraj", "Jadadeli","11-01-2004","11-01-2006","basavarajjadadheli@gmail.com","Banglore", "560035",false)).collect(Collectors.toList()));
		assertEquals(2,impl.SortByDateofJoinAndDateofBirth().size());
	}


    @Test
    public void getUserByName() {
    	
    	String name="Basavaraj";
    	when(repo.findByfirstName(name)).thenReturn(
    			 Stream.of(new User(1,"Basavraj", "Jadadeli","11-01-2004","11-01-2006","basavarajjadadheli@gmail.com","Banglore", "560035",false)).collect(Collectors.toList()));
    	assertEquals(1,impl.findUserByfirstName(name).size());
    }
 
    
    
    @Test
    public void deleteUserTest() {
		User user = new User(1,"rajj", "Jadadeli","11-01-2004","11-01-2006","basavarajjadadheli@gmail.com","Banglore", "560035",false);
		repo.save(user);
		impl.userSoftDelete(1);
		User usermock=null;
		Optional<User> optionalUser=repo.findById(1);
		
		if(optionalUser.isPresent()) {
			usermock=optionalUser.get();}
		 Assertions.assertThat(usermock).isNull();
    }
    
   
   
    
}



