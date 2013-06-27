package com.jroadie.tvprogram.dao;

import java.util.List;

import com.jroadie.tvprogram.model.Program;

public interface ProgramDAO {
	
	public Program addProgram(Program program);
	public Program updateProgram(Program program);
	public void deleteProgram(Program program);
	public Program getProgram(int id);
	public List<Program> getProgramList(int offset, int limit);
	
}
