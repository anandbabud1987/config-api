/**
 * File Name:ConfigResource.java
 * Author:Ananda Babu D
 * Date:Apr 3,2018
 *
 */
package com.rbc.test.rest.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rbc.test.constants.ExceptionMessage;
import com.rbc.test.constants.MessageContants;
import com.rbc.test.model.Config;
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
	/**
	 * 
	 * @param appCode
	 * @param version
	 * @param payLoad
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = "/{appCode}/config/{version}", method = RequestMethod.POST,produces="application/json",consumes="application/json")
	public ResponseEntity<Object> saveConfig(
			@PathVariable(name="appCode") String appCode,
			@PathVariable(name="version") String version,
			@RequestBody String payLoad
			) throws ApiException{
		logger.info("ConfigController:saveConfig started.");
		ConfigResponse response=null;
		try {
			response=new ConfigResponse();
			if(ConfigUtil.isValidInputData(appCode,version)) {//To Validate whether input has valid path parameters or not
				response=configService.saveConfig(appCode,version,payLoad);
			}
			else {
				response.setStatus(HttpStatus.BAD_REQUEST.toString());
				response.setError(MessageContants.INPUTS_MISSING);
			}
		}
		catch(Exception exception) {
			logger.error("Exception occurred in ConfigController:getConfig:",exception.getCause());
			response=new ConfigResponse();
			response.setError(ExceptionMessage.UNABLE_TO_GET.exceptionMessage());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
			return ConfigUtil.buildErrorResponse(response);
		}
		logger.info("ConfigController:saveConfig ended.");
		return ConfigUtil.buildResponse(response);
	}
	/**
	 * 
	 * @param appCode
	 * @param version
	 * @return
	 * @throws ApiException
	 */
	@RequestMapping(value = "/{appCode}/config/{version}", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Object> getConfig(
			@PathVariable(name="appCode") String appCode,
			@PathVariable(name="version") String version
			) throws ApiException{
		logger.info("ConfigController:getConfig started.");
		ConfigResponse response=null;
		try {
			response=new ConfigResponse();
			if(ConfigUtil.isValidInputData(appCode,version)) {//To Validate whether input has valid path parameters or not
				List<Config> result=configService.getConfig(appCode, version);
				if(result!=null && result.size()>0) {
					Config config=result.get(0);
					if(config!=null) {
						response.setAppCode(String.valueOf(config.getAppCode()));
						response.setVersion(String.valueOf(config.getVersion()));
					}
				}
				else {
					response.setStatus(HttpStatus.OK.toString());
					response.setError(MessageContants.NO_RESULT_FOUND);
					
				}
				
			}
			else {
				response.setStatus(HttpStatus.BAD_REQUEST.toString());
				response.setError(MessageContants.INPUTS_MISSING);
			}
		}
		catch(Exception exception) {
			logger.error("Exception occurred in ConfigController:getConfig:",exception.getCause());
			response=new ConfigResponse();
			response.setError(ExceptionMessage.UNABLE_TO_GET.exceptionMessage());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
			return ConfigUtil.buildErrorResponse(response);
		}
		logger.info("ConfigController:getConfig ended.");
		return ConfigUtil.buildResponse(response);
	}
	
	@RequestMapping(value = "/{appCode}/config", method = RequestMethod.GET,produces="application/json")
	public ResponseEntity<Object> getConfigAll(
			@PathVariable(name="appCode") String appCode) throws ApiException{
		logger.info("getConfigAll started.");
		ConfigResponse response=null;
		try {
			response=new ConfigResponse();
			if(ConfigUtil.isValidInputData(appCode)) {//To Validate whether input has valid path parameters or not
				List<Config> result=configService.getConfig(appCode);
				if(result!=null && result.size()>0) {
					result.parallelStream().forEach(action->{
						logger.info(action.getAppCode());
						logger.info(action.getVersion());
						logger.info(action.getContent());
					});
				}
				else {
					response.setStatus(HttpStatus.OK.toString());
					response.setError(MessageContants.NO_RESULT_FOUND);
					
				}
				
			}
			else {
				response.setStatus(HttpStatus.BAD_REQUEST.toString());
				response.setError(MessageContants.INPUTS_MISSING);
			}
		}
		catch(Exception exception) {
			logger.error("Exception occurred in ConfigController:getConfig:",exception.getCause());
			response=new ConfigResponse();
			response.setError(ExceptionMessage.UNABLE_TO_GET.exceptionMessage());
			response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.name());
			return ConfigUtil.buildErrorResponse(response);
		}
		logger.info("getConfigAll ended.");
		return ConfigUtil.buildResponse(response);
	}

	
}
