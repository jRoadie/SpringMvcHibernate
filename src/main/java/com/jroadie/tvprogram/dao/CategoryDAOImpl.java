package com.jroadie.tvprogram.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jroadie.tvprogram.model.Program;
import com.jroadie.tvprogram.model.Category;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Category add(Category category) {
		sessionFactory.getCurrentSession().save(category);
		sessionFactory.getCurrentSession().flush();
		return category;
	}

	@Override
	public Category update(Category category) {
		sessionFactory.getCurrentSession().update(category);
		sessionFactory.getCurrentSession().flush();
		return category;
	}

	@Override
	public void delete(Category category) {
		sessionFactory.getCurrentSession().delete(category);
	}

	@Override
	public Category get(int id) {
		Category category = (Category) sessionFactory.getCurrentSession().get(Category.class, id);
		return category;
	}
	
	@Override
	public List<Category> getList(int offset, int limit) {
		Query hql = sessionFactory.getCurrentSession().createQuery("from Category");
		hql.setFirstResult(limit * (offset - 1));
		hql.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Category> categoryList = hql.list();
		return categoryList;
	}

}
