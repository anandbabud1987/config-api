/**
 * File Name:ConfigResource.java
 * Author:Ananda Babu D
 * Date:Apr 3,2018
 *
 */
package com.rbc.test.rest.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rbc.test.constants.ExceptionMessage;
import com.rbc.test.constants.MessageContants;
import com.rbc.test.model.Config;
import com.rbc.test.rest.contracts.ConfigRequest;
import com.rbc.test.rest.contracts.ConfigResponse;
import com.rbc.test.rest.exception.ApiException;
import com.rbc.test.rest.service.ConfigService;
import com.rbc.test.util.ConfigUtil;


/**
 * This is a Resource Controller class for Config API
 * @author Ananda Babu Dhandapani
 *
 */
@RestController
@RequestMapping("/api")
public class ConfigController {

	public static final Logger logger = LoggerFactory.getLogger(ConfigController.class);
	
	@Autowired
	ConfigService configService;
	
	@RequestMapping(value = "/{appCode}/config/{version}", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Object> getConfig(
			@PathVariable(name="appCode") String appCode,
			@PathVariable(name="version") String version
			) throws ApiException{
		logger.info("getConfig started.");
		ConfigResponse response=null;
		try {
			response=new ConfigResponse();
			if(ConfigUtil.isValidInputData(appCode,version)) {//To Validate whether input has valid path parameters or not
				response=configService.saveConfig(appCode,version);
			}
			else {
				response.setStatus(HttpStatus.BAD_REQUEST.toString());
				response.setError(MessageContants.INPUTS_MISSING);
			}
		}
		catch(Exception exception) {
			logger.error("Exception occurred in ConfigController:getConfig:",exception.getCause());
			response=new ConfigResponse();
			response.setError(ExceptionMessage.UNABLE_TO_GET.toString());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
			ConfigUtil.buildErrorResponse(response);
		}
		logger.info("getConfig ended.");
		return ConfigUtil.buildResponse(response);
	}

	
}
