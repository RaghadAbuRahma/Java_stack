package com.axsos.beltreview.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.axsos.beltreview.models.Project;
import com.axsos.beltreview.models.User;
import com.axsos.beltreview.services.projectService;
import com.axsos.beltreview.services.userService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class projectController {
	
	
@Autowired
private projectService projectservice;
@Autowired
private userService userservice;



@RequestMapping("/projectForm")
public String projectForm(@ModelAttribute("project") Project project) {
	return "projectForm.jsp";
}
	

	
	@RequestMapping("/newProject")
	public String newProject(@Valid @ModelAttribute("project") Project project, BindingResult result, Model model,
			HttpSession session) {
		if (result.hasErrors()) {
			model.addAttribute("project", project);


			return "projectForm.jsp";

		} else {
			User loggedUser = (User) session.getAttribute("loggedUser");
		    Long loggedUserId = loggedUser.getId();
		    User user = userservice.findById(loggedUserId);			
			project.setLead(loggedUser);
			projectservice.newProject(project);
			projectservice.joinProject(user, project);

			 		

			return "redirect:/result";
		}
	}
	
	
	

		
	@RequestMapping("/joinProject/{id}")
	public String joinProject(@PathVariable("id") Long id, HttpSession session) {
		User loggedUser = (User) session.getAttribute("loggedUser");
	    Long loggedUserId = loggedUser.getId();
	    User user = userservice.findById(loggedUserId);
	    Project project = projectservice.findById(id);
	    projectservice.joinProject(user, project);
	    return "redirect:/result";
	}
	
	
	@RequestMapping("/leaveProject/{id}")
	public String leaveProject(@PathVariable("id") Long id, HttpSession session) {
		User loggedUser = (User) session.getAttribute("loggedUser");
	    Long loggedUserId = loggedUser.getId();
	    User user = userservice.findById(loggedUserId);
	    Project project = projectservice.findById(id);
	    projectservice.leaveProject(user, project);
	    return "redirect:/result";
	}
	    
	    
		
}
	
	
			



		
	
	
		
		
	
	

