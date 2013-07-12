package com.jroadie.tvprogram.dao;

import java.util.List;

import com.jroadie.tvprogram.model.Category;

public interface CategoryDAO {
	
	public Category add(Category category);
	public Category update(Category category);
	public void delete(Category category);
	public Category get(int id);
	public List<Category> getList(int offset, int limit);
	
}
