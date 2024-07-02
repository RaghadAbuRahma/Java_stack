package com.axsos.dojoandninjas.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.axsos.dojoandninjas.models.Dojo;
import com.axsos.dojoandninjas.models.Ninja;
import com.axsos.dojoandninjas.services.DojoService;
import com.axsos.dojoandninjas.services.NinjaService;

import jakarta.validation.Valid;
@Controller
public class NinjaController {
	/*
	 * private final NinjaService ninjaService;
	 * 
	 * public NinjaController(NinjaService ninjaService) { this.ninjaService =
	 * ninjaService; }
	 */
	
	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	
	
	@RequestMapping("/ninja/new")
	public String Form(@ModelAttribute("ninja") Ninja ninja, Model model) {
		
		model.addAttribute("dojos", dojoService.allDojos());
		return "ninja.jsp";
	}
	
	  @RequestMapping("ninja/create")
	  public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult
	  result,Model model) { 
	  if (result.hasErrors()) {
	  List<Ninja> ninjas = ninjaService.allNinjas(); 
	  model.addAttribute("ninjas", ninjas);
	  return "index.jsp";
	  } 
	  else {
	  ninjaService.createNinja(ninja);
	 return "redirect:/";
	 } 
	  }
	 


}
