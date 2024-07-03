package com.axsos.savetravels.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.axsos.savetravels.models.Expenses;
import com.axsos.savetravels.services.ExpensesService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	private final ExpensesService expensesService;

	public MainController(ExpensesService expensesService) {
		this.expensesService = expensesService;
	}

	@RequestMapping("/expenses")
	public String index(@ModelAttribute("expense") Expenses expense, Model model) {

		List<Expenses> expenses = expensesService.allExpenses();
		model.addAttribute("expenses", expenses);
	 
		return "index.jsp";

	}

	@PostMapping("/new")
	public String create(@Valid @ModelAttribute("expense") Expenses expense, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<Expenses> expenses = expensesService.allExpenses();
			model.addAttribute("expenses", expenses);
			return "index.jsp";
		} else {
			expensesService.createExpense(expense);
			return "redirect:/expenses";
		}
	}

	
	  @RequestMapping("expenses/edit/{id}")
	  public String edit(@PathVariable("id") Long id, Model model){
	  Optional<Expenses> expense = expensesService.findExpense(id);
	  model.addAttribute("expense", expense);
	  return "edit.jsp";
	  }
	  
	  @RequestMapping(value="expenses/{id}", method=RequestMethod.PUT)
	   public String update(@Valid @ModelAttribute("expense") Expenses expense, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            model.addAttribute("expense", expense);
	            return "edit.jsp";
	        } else {
	        	expensesService.updateExpense(expense);
	            return "redirect:/expenses";
	        }
	  }
	  
	  @RequestMapping("expenses/show/{id}")

	  public String show(@PathVariable Long id, Model model) {
		    Optional<Expenses> expense = expensesService.findExpense(id);

		    if (expense.isPresent()) {
		        model.addAttribute("expense", expense.get());
		    } else {
		        model.addAttribute("error", "Expense not found");
		    }

		    return "show.jsp";
		}
	  
	  @RequestMapping(value="expenses/delete/{id}", method=RequestMethod.DELETE)
	  public String delete(@PathVariable("id") Long id) {
		  expensesService.deleteExpense(id);
		  return "redirect:/expenses";
		  
		  
	  }
	  
	 

}
