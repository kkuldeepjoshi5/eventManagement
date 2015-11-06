package com.eventManagement.vo;

import java.util.Date;

import com.eventManagement.entity.Event;

public class EventVO{

	private Long id;

	private String title;

	private String description;

	private Date fromDate;

	private Date toDate;

	private String photoUrl;

	private Boolean deleted;

	private Long requestId;

	public EventVO(){

	}

	public EventVO(Event event){
		if(event.getId()!=null){
			this.id=event.getId();
		}
		if(event.getTitle()!=null){
			this.title=event.getTitle();
		}
		if(event.getDescription()!=null){
			this.description=event.getDescription();
		}
		if(event.getFromDate()!=null){
			this.fromDate=event.getFromDate();
		}
		if(event.getToDate()!=null){
			this.toDate=event.getToDate();
		}
		if(event.getPhotoUrl()!=null){
			this.photoUrl=event.getPhotoUrl();
		}
		if(event.getRequestId()!=null){
			this.requestId=event.getRequestId();
		}
		if(event.getIsDeleted()!=null){
			this.deleted=event.getIsDeleted();
		}
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getPhotoUrl() {
		return photoUrl;
	}

	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

}