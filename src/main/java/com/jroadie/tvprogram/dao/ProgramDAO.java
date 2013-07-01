package com.jroadie.tvprogram.dao;

import java.util.List;

import com.jroadie.tvprogram.model.Program;

public interface ProgramDAO {
	
	public Program add(Program program);
	public Program update(Program program);
	public void delete(Program program);
	public Program get(int id);
	public List<Program> getList(int offset, int limit);
	
}
