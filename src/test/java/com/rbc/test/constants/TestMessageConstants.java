package com.rbc.test.constants;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestMessageConstants {
	
	@Test
	public void testMessageConstants() {
		assertEquals("Config JSON Document Saved successfully", MessageContants.SUCCESS);
		assertEquals("One of Input is missing for AppCode and Version. please provide valid inputs", MessageContants.INPUTS_MISSING);
		assertEquals("No Results Founds for the given input.", MessageContants.NO_RESULT_FOUND);
		
	}

}
