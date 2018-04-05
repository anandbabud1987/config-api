package com.rbc.test.rest.repository;

import static org.junit.Assert.assertNotNull;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rbc.test.model.Config;
import com.rbc.test.repository.ConfigRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.rbc.test.ConfigApiApplication.class)
public class TestConfigRepository {
	
	@Autowired
	ConfigRepository configRepository;
	@Test
	public void testSaveConfig() {
		Config config=new Config();
		config.setAppCode("App1");
		config.setVersion("1.0");
		config.setContent("{'name':'firstname'}");
		config.setLastModifiedDates(new Date());
		assertNotNull(configRepository.save(config));
	}

}
