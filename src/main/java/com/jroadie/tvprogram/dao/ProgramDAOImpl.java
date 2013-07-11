package com.jroadie.tvprogram.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jroadie.tvprogram.model.Program;

@Repository
public class ProgramDAOImpl implements ProgramDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Program add(Program program) {
		sessionFactory.getCurrentSession().save(program);
		sessionFactory.getCurrentSession().flush();
		return program;
	}

	@Override
	public Program update(Program program) {
		sessionFactory.getCurrentSession().update(program);
		sessionFactory.getCurrentSession().flush();
		return program;
	}

	@Override
	public void delete(Program program) {
		sessionFactory.getCurrentSession().delete(program);
	}
	
	@Override
	public Program get(int id) {
		Program program = (Program) sessionFactory.getCurrentSession().get(Program.class, id);
		return program;
	}

	@Override
	public List<Program> getList(int offset, int limit) {
		Query hql = sessionFactory.getCurrentSession().createQuery("from Program");
		hql.setFirstResult(limit * (offset - 1));
		hql.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Program> programList = hql.list();
		return programList;
	}

}
