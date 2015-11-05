package com.eventManagement.entity;

import java.util.Date;

import com.eventManagement.vo.UserVO;

public class User {

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
	
	public User(){
		
	}
	public User(UserVO userVO) {
		if(userVO.getDob()!=null){
			this.dob=userVO.getDob();
		}
		if(userVO.getPhotoUrl()!=null){
			this.photoUrl=userVO.getPhotoUrl();
		}
		if(userVO.getRequestId()!=null){
			this.requestId=userVO.getRequestId();
		}
		if(userVO.getId()!=null){
			this.id=userVO.getId();
		}
		if(userVO.getFirstName()!=null){
			this.firstName=userVO.getFirstName();
		}
		if(userVO.getLastName()!=null){
			this.lastName=userVO.getLastName();
		}
		if(userVO.getEmail()!=null){
			this.email=userVO.getEmail();
		}
		if(userVO.getPassword()!=null){
			this.email=userVO.getPassword();
		}
		if(userVO.getRole()!=null){
			this.role=userVO.getRole();
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
