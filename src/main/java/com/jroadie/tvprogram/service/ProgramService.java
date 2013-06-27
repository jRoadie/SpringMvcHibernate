package com.jroadie.tvprogram.service;

import java.util.List;

import com.jroadie.tvprogram.model.Program;

public interface ProgramService {
	
	public Program addProgram(Program program);
	public Program updateProgram(Program program);
	public void deleteProgram(int id);
	public Program getProgram(int id);
	public List<Program> getProgramList(int offset, int limit);

}
