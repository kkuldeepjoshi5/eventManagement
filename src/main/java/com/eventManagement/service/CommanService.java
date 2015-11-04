package com.eventManagement.service;

import java.util.List;

import com.eventManagement.utility.Message;


public interface CommanService<E> {

	public Message delete(long id);

	public Message insert(E e);

	public List<E> getAll();

	public Message update(E e);
	
	public E getById(long id);


}
