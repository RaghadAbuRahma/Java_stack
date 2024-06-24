package com.axsos.displaydate;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;




@Controller
public class HomeController {
	 @RequestMapping("/")
	 public String index() {
		 return "index.jsp";
		 
	 }
	 
	 @RequestMapping("/date")
	 public String date(Model model) {
		 SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM d, yyyy ");  
		 Date date = new Date(); 
		 model.addAttribute( "date", formatter.format(date));
		 return "date.jsp";
		 
	 }
	 
	 @RequestMapping("/time")
	 public String time(Model model) {
		 SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");  
		 Date time = new Date(); 
		 model.addAttribute( "time", formatter.format(time));
		 return "time.jsp";
		 
	 }
	 
	 
	

}
