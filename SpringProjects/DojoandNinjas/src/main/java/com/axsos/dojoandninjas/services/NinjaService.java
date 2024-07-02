package com.axsos.dojoandninjas.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.axsos.dojoandninjas.models.Ninja;
import com.axsos.dojoandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	

 private final NinjaRepository ninjaRepository;
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    
    
    public List<Ninja> allNinjas(){
    	return ninjaRepository.findAll();
    	
    }
    
    public Ninja  createNinja(Ninja ninja) {
    	return ninjaRepository.save(ninja);
    }

}
