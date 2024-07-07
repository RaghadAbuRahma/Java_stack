package com.axsos.beltreview.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.beltreview.models.User;

@Repository
public interface userRepository extends CrudRepository<User, Long> {
	
	
    Optional<User> findByEmail(String email);
    


}
