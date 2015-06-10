package com.samuk.services;

import java.util.List;


public interface ObjectOperations <T> {

	
	public T create(T t);
	public T update(T t);
	public T find(Long id);
	public List<T> listAll();
	public void remove(Long id);
	public String toString();
		
}
