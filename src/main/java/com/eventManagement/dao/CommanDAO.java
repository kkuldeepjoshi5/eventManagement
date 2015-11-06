package com.eventManagement.dao;

import java.util.List;

import com.eventManagement.utility.Message;

public interface CommanDAO<E> {

	public Message insert(E e);
	public Message remove(Long id,Class<E> tempClass);
	public List<E> getAll();
	public E getById(Long id,Class<E> tempClass);
	public Message update(E e);
}
