package com.eventManagment.Service;

import java.util.List;

import com.eventManagment.Utility.Message;


public interface CommanService<E> {

	public Message delete(long id);

	public Message insert(E e);

	public List<E> getAll();

	public Message update(E e);
	
	public E getById(long id);


}
