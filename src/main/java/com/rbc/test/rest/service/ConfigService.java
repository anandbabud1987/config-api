package com.rbc.test.rest.service;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rbc.test.constants.MessageContants;
import com.rbc.test.constants.NamedQueryConstants;
import com.rbc.test.model.Config;
import com.rbc.test.repository.ConfigRepository;
import com.rbc.test.rest.contracts.ConfigResponse;

@Service
public class ConfigService {
	@Autowired
	ConfigRepository configRepository;
	
	@PersistenceContext
	private EntityManager entityManager;
	/**
	 * To Save/Update Config JSON Document
	 * @param config
	 */
	public ConfigResponse saveConfig(String appCode,String version) {
		Config config=new Config();
		config.setAppCode(appCode);
		config.setVersion(version);
		config.setLastModifiedDates(new Date());
		return populateResponse(configRepository.save(config));
	}
	
	/**
	 * To populate Response for saved config
	 * @param config
	 * @return
	 */
	protected ConfigResponse populateResponse(Config config) {
		ConfigResponse response=new ConfigResponse();
		response.setAppCode(config.getAppCode());
		response.setVersion(config.getVersion());
		response.setStatus(MessageContants.SUCCESS);
		response.setError("");
		return response;
	}
	/**
	 * To Get Config  for a give appCode and version
	 * @param appCode
	 * @param version
	 * @return List<Config>
	 */
	public List<Config> getConfig(String appCode,String version){
		
		Query query=entityManager.createNamedQuery(NamedQueryConstants.CONFIG_FIND_APP_VERSION);
		query.setParameter("appCode", appCode);
		query.setParameter("version", version);
		return query.getResultList();
		
	}
	
	/**
	 * To Get Config List of a give appCode order by last modified date in desc order
	 * @param appCode
	 * @return
	 */
	public List<Config> getConfig(String appCode){
		
		Query query=entityManager.createNamedQuery(NamedQueryConstants.CONFIG_FIND_ALL_APP_CODE);
		query.setParameter("appCode", appCode);
		return query.getResultList();
		
	}

}
