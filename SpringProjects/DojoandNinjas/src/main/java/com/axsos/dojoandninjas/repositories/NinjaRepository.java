package com.axsos.dojoandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.axsos.dojoandninjas.models.Ninja;

public interface NinjaRepository  extends CrudRepository<Ninja, Long> {
	List<Ninja> findAll();

}
