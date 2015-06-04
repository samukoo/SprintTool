package com.samuk.services;


public interface ObjectOperations <T> {

	
	public T create(T t);
	public T update(T t);
	public T find(Long id);
	public void remove(Long id);
	public String toString();
		
}
