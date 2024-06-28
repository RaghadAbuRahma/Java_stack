package com.axsos.burgertracker.services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.axsos.burgertracker.models.Burger;
import com.axsos.burgertracker.repositories.BurgerRepository;




@Service
public class BurgerService {
	 private final BurgerRepository burgerRepository;
	    
	    public BurgerService(BurgerRepository burgerRepository) {
	        this.burgerRepository = burgerRepository;
	    }
	    
	    public List<Burger> allBurgers() {
	        return burgerRepository.findAll();
	    }

	
}

