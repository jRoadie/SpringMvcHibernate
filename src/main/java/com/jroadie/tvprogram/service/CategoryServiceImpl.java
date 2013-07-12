package com.jroadie.tvprogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jroadie.tvprogram.dao.CategoryDAO;
import com.jroadie.tvprogram.model.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	CategoryDAO categoryDAO;

	@Override
	public Category add(Category category) {
		return categoryDAO.add(category);
	}

	@Override
	public Category update(Category category) {
		Category categoryToUpdate = categoryDAO.get(category.getId());
		categoryToUpdate.setName(category.getName());
		categoryToUpdate.setDescription(category.getDescription());
		return categoryDAO.update(categoryToUpdate);
	}

	@Override
	public void delete(int id) {
		Category categoryToDelete = categoryDAO.get(id);
		if(categoryToDelete != null){
			categoryDAO.delete(categoryToDelete);
		}
	}

	@Override
	public Category get(int id) {
		return categoryDAO.get(id);
	}

	@Override
	public List<Category> getList(int offset, int limit) {
		return categoryDAO.getList(offset, limit);
	}

}
