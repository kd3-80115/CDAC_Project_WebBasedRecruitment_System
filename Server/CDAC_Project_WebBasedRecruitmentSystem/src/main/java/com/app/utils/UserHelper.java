package com.app.utils;




import com.app.entities.UserEntity;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.UserEntityRepository;

//helper class to overcome frequently writing logic to find user entity from email
public class UserHelper {
	
	
	
	public static UserEntity findUserByEmail(String email,UserEntityRepository userDao){
		
		//finds persistent user entity by email obtained from authentication object
		UserEntity user = userDao.findByEmail(email).
				orElseThrow(()-> new ResourceNotFoundException
						("User", "Email ID", email));
		// Returns the value in case of non empty Optional
			// OR throws supplied exception
		return user;
	}
}
