package com.rbc.test.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

/**
 * This is an Utility Class
 * @author agl
 *
 */
@Component
public class ConfigUtil {


	public static ResponseEntity<Object> buildResponse(Object object) {
	
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}
	
	public static ResponseEntity<Object> buildErrorResponse(Object object) {
		
		return new ResponseEntity<Object>(object, HttpStatus.OK);
	}

	public static boolean isValidInputData(String appCode, String version) {
		
		return (appCode!=null && version!=null);
	}

}
