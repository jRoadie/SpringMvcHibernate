package com.jroadie.tvprogram.service;

import java.util.List;

import com.jroadie.tvprogram.model.Schedule;

public interface ScheduleService {
	
	public Schedule add(Schedule schedule);
	public Schedule update(Schedule schedule);
	public void delete(int id);
	public Schedule get(int id);
	public List<Schedule> getList(int offset, int limit);

}
