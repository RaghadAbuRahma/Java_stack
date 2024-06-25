package com.axsos.counter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpSession;







@Controller
public class HomeController {

	
@RequestMapping("/counter")
public String index(HttpSession session) {
	Integer count = 0;
	
	
	 if (session.setAttribute("count") == null) {
		 session.setAttribute("count", 0);
	 }
	 else {
		 count = (Integer) session.setAttribute("count");
		 count ++;
		 session.setAttribute("count", count);
		 
	 }
	 
	
	return "index.jsp";
	
}


}
