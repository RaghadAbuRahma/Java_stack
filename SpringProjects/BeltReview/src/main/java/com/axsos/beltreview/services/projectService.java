package com.axsos.beltreview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.axsos.beltreview.models.Project;
import com.axsos.beltreview.models.User;
import com.axsos.beltreview.repositories.projectRepository;
import com.axsos.beltreview.repositories.userRepository;

@Service
public class projectService {
	
	@Autowired
	projectRepository projectRepo;
	@Autowired
	userRepository userRepo;

	public Project findById(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}else {
			return null;
		}
	}
	

	
	public List<Project> otherProjects(User user){
		return projectRepo.findByUsersNotContains(user);
		
	}
	
	public Project newProject(Project project) {
		return projectRepo.save(project);
		
	}
	
	public List<Project> myProjects(User user){
		return projectRepo.findAllByUsers(user);
	}
	
	public void joinProject(User user, Project project) {
		user.getProjects().add(project);
		userRepo.save(user);
	}
	
	public void leaveProject(User user, Project project) {
		user.getProjects().remove(project);
		userRepo.save(user);	
	}
}
