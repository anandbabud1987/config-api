package com.rbc.test.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rbc.test.model.Config;
import com.rbc.test.repository.ConfigRepository;

@Service
public class ConfigService {
	@Autowired
	ConfigRepository configRepository;
	
	public void saveConfig() {
		Config config=new Config();
		config.setAppCode("Hellow");
		config.setVersion("hello");
		config.setContent("dai");
		configRepository.save(config);
	}

}
