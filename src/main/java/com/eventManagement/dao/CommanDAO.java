package com.eventManagement.dao;

import java.util.List;

import com.eventManagement.utility.Message;

public interface CommanDAO<E> {

	public Message insert(E e);
	public Message delete(Long eventId);
	public List<E> getAll();
	public E getById(Long eventId);
	public Message update(E e);
}
