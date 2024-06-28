package com.axsos.omikujiform;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.HttpSession;




@Controller
public class MainController {
	
	@RequestMapping("/omikuji")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/omikuji/show")
	public String show(HttpSession session) {
			return "show.jsp";
	
		}

	
	
	@RequestMapping("/omikuji/new")
	public String newForm(HttpSession session, Model model,
		@RequestParam(value="number") String number,
	    	@RequestParam(value="city") String city,
	    	@RequestParam(value="person") String person,
	    	@RequestParam(value="hobby") String hobby,
	    	@RequestParam(value="living_thing") String living_thing,
	    	@RequestParam(value="smth_nice") String smth_nice) {

		 	session.setAttribute("number",number);
		 	session.setAttribute("city",city);
		 	session.setAttribute("person",person);
		 	session.setAttribute("hobby",hobby);
		 	session.setAttribute("living_thing",living_thing);
		 	session.setAttribute("smth_nice",smth_nice);
		 	
	    	return "redirect:/omikuji/show";
	}
	
	@RequestMapping("/omikuji/goback")
	public String goback() {
		return "redirect:/omikuji";
	}

	

}


