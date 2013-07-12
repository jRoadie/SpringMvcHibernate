package com.jroadie.tvprogram.service;

import java.util.List;

import com.jroadie.tvprogram.model.Category;

public interface CategoryService {
	
	public Category add(Category category);
	public Category update(Category category);
	public void delete(int id);
	public Category get(int id);
	public List<Category> getList(int offset, int limit);
	
}
