package com.rbc.test.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.rbc.test.model.Config;
/**
 * This is an interface which extends CrudRepostory
 * @author agl
 *
 */
@Component
public interface ConfigRepository extends JpaRepository<Config, Serializable> {
	
	

}



