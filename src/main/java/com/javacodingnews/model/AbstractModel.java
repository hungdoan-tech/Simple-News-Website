package com.javacodingnews.model;

import java.sql.Timestamp;

public class AbstractModel {

	private Long id;
    private Timestamp createDate; 
    private Timestamp modifiedDate;
    private String createdBy; 
    private String modifiedBy;
    private Long[] ids; 

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Timestamp getCreatedDate() {
		return createDate;
	}
	public void setCreatedDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public Timestamp getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Timestamp modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}	    
	public Long[] getIds() {
		return ids;
	}
	public void setIds(Long[] ids) {
		this.ids = ids;
	}
}
