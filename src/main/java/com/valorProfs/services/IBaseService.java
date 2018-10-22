package com.valorProfs.services;

import java.util.List;

public interface IBaseService<T> {

	public List<T> getAll();

	public T getOne(Integer id);

	public int insert(T item);

	public int update(T item);

	public int delete(Integer id);
}
