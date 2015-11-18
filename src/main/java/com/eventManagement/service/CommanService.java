package com.eventManagement.service;

import java.util.List;

import com.eventManagement.entity.EventUser;
import com.eventManagement.utility.Message;


public interface CommanService<E> {

	public Message remove(Long id);
	
	public List<E> deleteAll(List<E> deletableList);

	public E insert(E e);

	public List<E> getAll();

	public E update(E e);
	
	public List<E> updateAll(List<E> updatableList);

	public E getById(Long id);

	public List<E> getAllByIsDeleted(Boolean isDeleted);

	public List<E> insertAll(List<E> eList);

}
