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
		Schedule scheduleToUpdate = scheduleDAO.get(schedule.getId());
		scheduleToUpdate.setProgram(schedule.getProgram());
		scheduleToUpdate.setDate(schedule.getDate());
		scheduleToUpdate.setTime(schedule.getTime());
		scheduleToUpdate.setDuration(schedule.getDuration());
		return scheduleDAO.update(scheduleToUpdate);
	}

	@Override
	public void delete(int id) {
		Schedule scheduleToDelete = this.get(id);
		if(scheduleToDelete != null) {
			scheduleDAO.delete(scheduleToDelete);
		}
	}

	@Override
	public Schedule get(int id) {
		return scheduleDAO.get(id);
	}

	@Override
	public List<Schedule> getList(int offset, int limit) {
		return scheduleDAO.getList(offset, limit);
	}

}
