package com.jroadie.tvprogram.dao;

import java.util.List;

import com.jroadie.tvprogram.model.Schedule;

public interface ScheduleDAO {
	
	public Schedule add(Schedule schedule);
	public Schedule update(Schedule schedule);
	public void delete(Schedule schedule);
	public Schedule get(int id);
	public List<Schedule> getList(int offset, int limit);

}
