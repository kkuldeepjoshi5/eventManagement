package com.eventManagment.Entity;

import java.util.Date;

public class manager {

	private int  managerId;
	private String managerName;
	private String managerEmail;
	private Date managerPhoto;
	private String managerDesc;
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	public Date getManagerPhoto() {
		return managerPhoto;
	}
	public void setManagerPhoto(Date managerPhoto) {
		this.managerPhoto = managerPhoto;
	}
	public String getManagerDesc() {
		return managerDesc;
	}
	public void setManagerDesc(String managerDesc) {
		this.managerDesc = managerDesc;
	}
}
