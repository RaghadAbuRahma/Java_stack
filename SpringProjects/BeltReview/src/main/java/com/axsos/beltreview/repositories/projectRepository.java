package com.axsos.beltreview.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.axsos.beltreview.models.Project;
import com.axsos.beltreview.models.User;
@Repository
public interface projectRepository extends CrudRepository <Project, Long> {
	
	List<Project> findAll();
	Project findByIdIs(Long id);
	List<Project> findAllByUsers(User user);
	List<Project> findByUsersNotContains(User user);
}
	
	


