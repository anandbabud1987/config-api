package com.rbc.test.repository;

import java.io.Serializable;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.rbc.test.model.Config;

@Component
public interface ConfigRepository extends CrudRepository<Config, Serializable> {
	
	

}



