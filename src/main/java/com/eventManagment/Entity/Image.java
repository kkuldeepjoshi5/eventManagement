package com.eventManagment.Entity;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class Image {
	
	private MultipartFile eventPhoto;
	private File photoDir;
	private String url;
	
	public MultipartFile getEventPhoto() {
		return eventPhoto;
	}
	public void setEventPhoto(MultipartFile eventPhoto) {
		this.eventPhoto = eventPhoto;
	}
	public File getPhotoDir() {
		return photoDir;
	}
	public void setPhotoDir(File photoDir) {
		this.photoDir = photoDir;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}

}
