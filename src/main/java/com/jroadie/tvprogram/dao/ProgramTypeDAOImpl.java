package com.jroadie.tvprogram.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jroadie.tvprogram.model.Program;
import com.jroadie.tvprogram.model.ProgramType;

@Repository
public class ProgramTypeDAOImpl implements ProgramTypeDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public ProgramType add(ProgramType programType) {
		sessionFactory.getCurrentSession().save(programType);
		sessionFactory.getCurrentSession().flush();
		return programType;
	}

	@Override
	public ProgramType update(ProgramType programType) {
		sessionFactory.getCurrentSession().update(programType);
		sessionFactory.getCurrentSession().flush();
		return programType;
	}

	@Override
	public void delete(ProgramType programType) {
		sessionFactory.getCurrentSession().delete(programType);
	}

	@Override
	public ProgramType get(int id) {
		ProgramType programType = (ProgramType) sessionFactory.getCurrentSession().get(ProgramType.class, id);
		return programType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProgramType> getList(int offset, int limit) {
		Query hql = sessionFactory.getCurrentSession().createQuery("from ProgramType");
		hql.setFirstResult(limit * (offset - 1));
		hql.setMaxResults(limit);
		List<ProgramType> programTypeList = hql.list();
		return programTypeList;
	}

}
