package com.eventManagement.vo;



import java.util.Date;

import com.eventManagement.entity.User;


public class UserVO{
	
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String role;
	private Date dob;
	private String photoUrl;
	private Boolean isDeleted;
	private Long requestId;
	
	public UserVO(){
		
	}
		public UserVO(User user) {
		if(user.getDob()!=null){
			this.dob=user.getDob();
		}
		if(user.getPhotoUrl()!=null){
			this.photoUrl=user.getPhotoUrl();
		}
		if(user.getRequestId()!=null){
			this.requestId=user.getRequestId();
		}
		if(user.getId()!=null){
			this.id=user.getId();
		}
		if(user.getFirstName()!=null){
			this.firstName=user.getFirstName();
		}
		if(user.getLastName()!=null){
			this.lastName=user.getLastName();
		}
		if(user.getEmail()!=null){
			this.email=user.getEmail();
		}
	/*	if(user.getPassword()!=null){
			this.email=user.getPassword();
		}*/
		if(user.getRole()!=null){
			this.role=user.getRole();
		}
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
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