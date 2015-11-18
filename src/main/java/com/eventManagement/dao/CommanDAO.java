package com.eventManagement.dao;

import java.util.List;
import java.util.Map;

import com.eventManagement.entity.EventUser;
import com.eventManagement.utility.Message;

public interface CommanDAO<E> {

	public Long insert(E e);
	public Message remove(Long id,Class<E> tempClass);
	public List<E> getAll();
	public E getById(Long id,Class<E> tempClass);
	public E update(E e);
	public List<E> updateAll(List<E> updatableList);
	public List<E> getAllByIsDeleted(Boolean isDeleted);

	public Map<Long,E> insertAll(List<E> elist);
}
