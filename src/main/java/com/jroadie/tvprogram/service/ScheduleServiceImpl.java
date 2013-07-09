package com.jroadie.tvprogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jroadie.tvprogram.dao.ScheduleDAO;
import com.jroadie.tvprogram.model.Schedule;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
	
	@Autowired
	private ScheduleDAO scheduleDAO;

	@Override
	public Schedule add(Schedule schedule) {
		return scheduleDAO.add(schedule);
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
