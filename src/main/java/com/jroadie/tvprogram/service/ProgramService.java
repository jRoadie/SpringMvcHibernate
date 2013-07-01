package com.jroadie.tvprogram.service;

import java.util.List;

import com.jroadie.tvprogram.model.Program;

public interface ProgramService {
	
	public Program add(Program program);
	public Program update(Program program);
	public void delete(int id);
	public Program get(int id);
	public List<Program> getList(int offset, int limit);

}
