package com.rbc.test.rest.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rbc.test.model.Config;
import com.rbc.test.repository.ConfigRepository;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=com.rbc.test.ConfigApiApplication.class)
public class TestConfigService {
	
	@Autowired
	ConfigRepository configRepository;
	
	@Autowired
	ConfigService configService;
	
	public static String appCode = null;
	public static String version = null;
	public static String jsonPayLoad = null;
	
	@Before
	public void setup() {
		appCode="App1";
		version="1.1";
		jsonPayLoad="{'name':'anand','city':'Toronto'}";
	}
	
	@Test
	public void testSaveConfig() {
		
		assertNotNull(configService.saveConfig(appCode, version, jsonPayLoad));
	}
	
	@After
	public void testGetConfig() {
		List<Config> result = configService.getConfig(appCode, version);
		Config config=result.get(0);
		assertEquals(appCode,config.getAppCode());
		assertEquals(version,config.getVersion());
		assertEquals(jsonPayLoad, config.getContent());
	}
	@After
	public void testGetAllConfig() {
		List<Config> result = configService.getConfig(appCode);
		assertNotNull(result);
		
	}

}
