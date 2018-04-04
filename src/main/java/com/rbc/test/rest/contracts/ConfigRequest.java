/**
 * 
 */
package com.rbc.test.rest.contracts;
/**
 * File Name:ConfigRequest.java
 * Author:Ananda Babu D
 * Date:Apr 3,2018
 *
 */

import java.io.File;
import java.io.Serializable;

/**
 * @author agl
 *
 */
public class ConfigRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7382786228251231354L;
	
	private String appCode;
	private String version;
	private File document;
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
