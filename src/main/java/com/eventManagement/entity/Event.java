package com.eventManagement.entity;


import java.util.Date;

import com.eventManagement.vo.EventVO;

public class Event {

	private Long id;

	private String title;

	private String description;

	private Date fromDate;

	private Date toDate;

	private String photoUrl;

	private Boolean isDeleted =Boolean.FALSE;

	private Long requestId;

	public Event(){

	}
	public Event(EventVO eventVO){
		if(eventVO.getId()!=null){
			this.id=eventVO.getId();
		}
		if(eventVO.getTitle()!=null){
			this.title=eventVO.getTitle();
		}
		if(eventVO.getDescription()!=null){
			this.description=eventVO.getDescription();
		}
		if(eventVO.getFromDate()!=null){
			this.fromDate=eventVO.getFromDate();
		}
		if(eventVO.getToDate()!=null){
			this.toDate=eventVO.getToDate();
		}
		if(eventVO.getPhotoUrl()!=null){
			this.photoUrl=eventVO.getPhotoUrl();
		}
		if(eventVO.getRequestId()!=null){
			this.requestId=eventVO.getRequestId();
		}
		if(eventVO.getDeleted()!=null){
			this.isDeleted=eventVO.getDeleted();
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

	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Long getRequestId() {
		return requestId;
	}

	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}

}
