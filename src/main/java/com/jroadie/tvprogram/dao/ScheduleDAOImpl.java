package com.jroadie.tvprogram.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jroadie.tvprogram.model.Schedule;

@Repository
public class ScheduleDAOImpl implements ScheduleDAO {
	
	@Autowired
	private SessionFactory sf;
	
	@Override
	public Schedule add(Schedule schedule) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		session.save(schedule);
		
		session.getTransaction().commit();
		session.close();
		return null;
	}

	@Override
	public Schedule update(Schedule schedule) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Schedule get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Schedule> getList(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
