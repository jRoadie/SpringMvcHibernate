package com.jroadie.tvprogram.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jroadie.tvprogram.model.Schedule;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Schedule add(Schedule schedule) {
		sessionFactory.getCurrentSession().save(schedule);
		return schedule;
	}

	@Override
	public Schedule update(Schedule schedule) {
		sessionFactory.getCurrentSession().update(schedule);
		sessionFactory.getCurrentSession().flush();
		return schedule;
	}

	@Override
	public void delete(Schedule schedule) {
		sessionFactory.getCurrentSession().delete(schedule);
	}

	@Override
	public Schedule get(int id) {
		Schedule schedule = (Schedule) sessionFactory.getCurrentSession().get(Schedule.class, id);
		return schedule;
	}

	@Override
	public List<Schedule> getList(int offset, int limit) {
		Query hql = sessionFactory.getCurrentSession().createQuery("from Schedule");
		hql.setFirstResult(limit * (offset - 1));
		hql.setMaxResults(limit);
		
		@SuppressWarnings("unchecked")
		List<Schedule> scheduleList = hql.list();
		return scheduleList;
	}

}
