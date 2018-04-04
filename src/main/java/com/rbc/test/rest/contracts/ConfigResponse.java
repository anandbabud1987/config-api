package com.rbc.test.rest.contracts;
/**
 * File Name:ConfigResponse.java
 * Author:Ananda Babu D
 * Date:Apr 3,2018
 *
 */

import java.io.File;
import java.io.Serializable;

/**
 * This is a pojo class for Config Response Entity
 * @author Ananda Babu Dhandapani
 *
 */
public class ConfigResponse implements Serializable {
	
	private static final long serialVersionUID = 6246482139802833549L;
	private String appCode;
	private String version;
	private File document;
	private String error;
	private String status;
	/**
	 * @return the error
	 */
	public String getError() {
		return error;
	}
	/**
	 * @param error the error to set
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the appCode
	 */
	public String getAppCode() {
		return appCode;
	}
	/**
	 * @param appCode the appCode to set
	 */
	public void setAppCode(String appCode) {
		this.appCode = appCode;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
	/**
	 * @return the document
	 */
	public File getDocument() {
		return document;
	}
	/**
	 * @param document the document to set
	 */
	public void setDocument(File document) {
		this.document = document;
	}

}
