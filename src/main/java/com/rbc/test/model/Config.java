package com.rbc.test.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="CONFIG",schema="bschema")
@NamedQueries({
    @NamedQuery(name="Config.findAllByAppCode",
                query="select a  from Config a where a.appCode=:appCode order by lastModifiedDates desc"),
    @NamedQuery(name="Config.findAllByAppCodeAndVersion",
    query="select a  from Config a where a.appCode=:appCode and a.version=:version order by lastModifiedDates desc"),
})
public class Config implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4714742983148838211L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="APP_CODE",nullable = false,length=10)
	private String appCode;

	@Column(name="VERSION",nullable = false,length=5)
	private String version;
	
	@Column(name="DOCUMENT_CONTENT",nullable = false,length=1000)
	private String content;
	
	@Column(name="LAST_MODIFIED_DATE",nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDates;
	
	/**
	 * @return the lastModifiedDates
	 */
	public Date getLastModifiedDates() {
		return lastModifiedDates;
	}
	/**
	 * @param lastModifiedDates the lastModifiedDates to set
	 */
	public void setLastModifiedDates(Date lastModifiedDates) {
		this.lastModifiedDates = lastModifiedDates;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	

}
