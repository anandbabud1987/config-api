package com.rbc.test.constants;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestExceptionMessage {
	
	@Test
	public void testExceptionMessage() {
		assertEquals("Unable to fetch document details", ExceptionMessage.UNABLE_TO_GET.exceptionMessage());
		
	}

}
