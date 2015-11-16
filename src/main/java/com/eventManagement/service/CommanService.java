package com.eventManagement.service;

import java.util.List;

import com.eventManagement.entity.EventUser;
import com.eventManagement.utility.Message;


public interface CommanService<E> {

	public Message remove(Long id);

	public E insert(E e);

	public List<E> getAll();

	public E update(E e);

	public E getById(Long id);
	
	public List<E> getAllByIsDeleted(Boolean isDeleted);

	List<EventUser> insertAll(List<EventUser> eventUserList);
	
}
