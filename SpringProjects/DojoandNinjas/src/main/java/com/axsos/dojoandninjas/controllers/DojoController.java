package com.axsos.dojoandninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.dojoandninjas.models.Dojo;
import com.axsos.dojoandninjas.services.DojoService;

import jakarta.validation.Valid;

@Controller
public class DojoController {

	private final DojoService dojoService;

	public DojoController(DojoService dojoService) {
		this.dojoService = dojoService;
	}

	@RequestMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "index.jsp";
	}

	
	  @RequestMapping("dojo/new")
	  public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult
	  result,Model model) { 
	  if (result.hasErrors()) {
	  List<Dojo> dojos = dojoService.allDojos(); 
	  model.addAttribute("dojos", dojos);
	  return "index.jsp";
	  } 
	  else {
	  dojoService.createDojo(dojo);
	 return "redirect:/";
	 } 
	  }
	 
	 

}
