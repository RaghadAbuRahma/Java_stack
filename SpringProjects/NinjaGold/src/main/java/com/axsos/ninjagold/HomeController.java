package com.axsos.ninjagold;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
    	
        if (count == null) {
            count = 0;
            session.setAttribute("count", count);
        }
        model.addAttribute("count", count);
        return "index.jsp";
    }

    @SuppressWarnings("unchecked")
    @PostMapping("/process_money")
    public String processMoney(@RequestParam("which_form") String location, HttpSession session) {
        Integer count = (Integer) session.getAttribute("count");
        if (count == null) {
            count = 0;
        }

        ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
        if (activities == null) {
            activities = new ArrayList<>();
        }

        int amount = 0;
        SimpleDateFormat simpleFormat = new SimpleDateFormat("MMMM d Y h:mm a");
        switch (location) {
            case "farm":
                amount = (int) (Math.random() * (20 - 10 + 1) + 10);
                count += amount;
                activities.add(0,"You entered a farm and earned " + amount + " gold.("+simpleFormat.format(new Date())+")");
                break;
            case "cave":
                amount = (int) (Math.random() * (10 - 5 + 1) + 5);
                count += amount;
                activities.add(0,"You entered a cave and earned " + amount + " gold.("+simpleFormat.format(new Date())+")");
                break;
            case "house":
                amount = (int) (Math.random() * (5 - 2 + 1) + 2);
                count += amount;
                activities.add(0,"You entered a house and earned " + amount + " gold.("+simpleFormat.format(new Date())+")");
                break;
            case "quest":
                amount = (int) (Math.random() * (50 - (-50) + 1) + (-50));
                count += amount;
                if (amount >= 0) {
                    activities.add(0,"You completed a quest and earned " + amount + " gold.("+simpleFormat.format(new Date())+")");
                } else {
                    activities.add(0,"You failed a quest and lost " + (-amount) + " gold.("+simpleFormat.format(new Date())+")");
                }
                break;
            default:
                amount = 0;
        }

        session.setAttribute("activities", activities);
        session.setAttribute("count", count);

        return "redirect:/";
    }
}

