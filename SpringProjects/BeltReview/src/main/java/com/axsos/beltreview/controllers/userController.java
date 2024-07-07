package com.axsos.beltreview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.axsos.beltreview.models.LoginUser;
import com.axsos.beltreview.models.Project;
import com.axsos.beltreview.models.User;
import com.axsos.beltreview.services.projectService;
import com.axsos.beltreview.services.userService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class userController {
	
@Autowired
private userService userService;
@Autowired 
private projectService projectservice; 
	
	@GetMapping("/")
	public String form(@ModelAttribute("newUser") User user, @ModelAttribute("login") LoginUser login, HttpSession session) {
		if(session.getAttribute("loggedUser") != null) {
			return "redirect:/result";
		}
		return "index.jsp";
		
		
	}
	
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User user, BindingResult result, Model model, HttpSession session) {
		User NU = userService.register(user , result);
		if(result.hasErrors()) {
	    model.addAttribute("login" , new LoginUser());			
			return "index.jsp"; 
		}
		if(session.getAttribute("loggedUser") == null) {
			session.setAttribute("loggedUser", NU);
		}
		
		return "redirect:/result";
		
		
		
		
		
	}
	
	@GetMapping("/result")
	public String result(HttpSession session, Model model) {
	    if (session.getAttribute("loggedUser") == null) {
	        return "redirect:/";
	    }

	    User loggedUser = (User) session.getAttribute("loggedUser");
	    Long loggedUserId = loggedUser.getId();
	    User user = userService.findById(loggedUserId);

	    List<Project> otherProjects = projectservice.otherProjects(user);
	    model.addAttribute("otherProjects", otherProjects);

	    List<Project> myProjects = projectservice.myProjects(user);
	    model.addAttribute("myProjects", myProjects);

	    return "result.jsp";
	}

	
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("login") LoginUser loginuser, BindingResult result, Model model, HttpSession session) {
		User loggedUser = 	userService.login(loginuser , result);
		if(result.hasErrors()) {
	    model.addAttribute("newUser" , new User());			
			return "index.jsp"; 
		}
		
		if(session.getAttribute("loggedUser") == null) {
		 session.setAttribute("loggedUser", loggedUser);
		}		return "redirect:/result";
	}
	
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		if(session.getAttribute("loggedUser") != null) {
			session.invalidate();
		}
		return "redirect:/";
	}
	
	
}
