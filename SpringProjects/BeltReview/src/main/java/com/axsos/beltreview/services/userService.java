package com.axsos.beltreview.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.axsos.beltreview.models.LoginUser;
import com.axsos.beltreview.models.User;
import com.axsos.beltreview.repositories.userRepository;

@Service
public class userService {
	
		
	@Autowired
	private userRepository userRepository;
	
	 public User register(User newUser, BindingResult result) {
		 Optional<User> optionalUser = userRepository.findByEmail(newUser.getEmail());
		 if(optionalUser.isPresent()) {
			 result.rejectValue("email","Found","The email you entered is already used");
			 return null;
		 }
		 if(!newUser.getConfirm().equals(newUser.getPassword())) {
			 result.rejectValue("password", "Matches", "The passwords you entered do not match");
			 return null;
		 }
		 
		 String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		 newUser.setPassword(hashed);
		 userRepository.save(newUser);
		 return newUser;
		 


	 }
	 
	 public User login(LoginUser login,  BindingResult result ) {
		 Optional<User> optionalUser = userRepository.findByEmail(login.getEmail());
		 if(!optionalUser.isPresent()) {
			 result.rejectValue("email","notFound","The email you entered does not exist");
			 return null;
		 }
		 
		 if(!BCrypt.checkpw(login.getPassword(), optionalUser.get().getPassword())) {
			    result.rejectValue("password", "Matches", "Invalid Password!");
			    return null;
			    
			}
		 return optionalUser.get();
			 	 
	 }
	 
	 public User findById(Long id) {
			Optional<User> optionalUser = userRepository.findById(id);
			if(optionalUser.isPresent()) {
				return optionalUser.get();
			}else {
				return null;
			}
		}
	 
	 
	 public User updateUser(User user) {
			return userRepository.save(user);
		}
	 
}
