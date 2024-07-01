package com.axsos.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.savetravels.models.Expenses;
import com.axsos.savetravels.repositories.ExpensesRepositoy;



@Service
public class ExpensesService {
    private final ExpensesRepositoy expensesRepo;
    public ExpensesService(ExpensesRepositoy expensesRepo) {
        this.expensesRepo = expensesRepo;
    }
    
    
    public List<Expenses> allExpenses() {
        return expensesRepo.findAll();
    }
    public Expenses createExpense(Expenses expense) {
    	return expensesRepo.save(expense);
    }
    public Expenses updateExpense(Expenses expense) {
    	return expensesRepo.save(expense);
    }
    public Optional<Expenses> findExpense(Long id) {
    	return expensesRepo.findById(id);
    	
    }
    public void deleteExpense(Long id) {
    	 expensesRepo.deleteById(id);
    }

}
