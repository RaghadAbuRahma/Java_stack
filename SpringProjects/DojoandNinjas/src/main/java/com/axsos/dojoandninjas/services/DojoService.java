package com.axsos.dojoandninjas.services;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.axsos.dojoandninjas.models.Dojo;
import com.axsos.dojoandninjas.repositories.DojoRepository;
@Service
public class DojoService {
	 private final DojoRepository dojoRepository;
	    public DojoService(DojoRepository dojoRepository) {
	        this.dojoRepository = dojoRepository;
	    }
	    
	    
	    public List<Dojo> allDojos(){
	        return dojoRepository.findAll();

	    }
	    
	    
	    public Dojo createDojo(Dojo dojo) {
	     return dojoRepository.save(dojo);
	    	
	    }
	    
	    public Optional<Dojo> FindDojo(Long id) {
	    	return dojoRepository.findById(id);
	    }
	    
}