package com.rbc.test.constants;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestNamedQueryConstants {
	
	@Test
	public void testNamedQuery() {
		assertEquals("Config.findAllByAppCode", NamedQueryConstants.CONFIG_FIND_ALL_APP_CODE);
		assertEquals("Config.findAllByAppCodeAndVersion", NamedQueryConstants.CONFIG_FIND_APP_VERSION);
		
	}

}
