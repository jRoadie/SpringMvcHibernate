package com.jroadie.tvprogram.dao;

import java.util.List;

import com.jroadie.tvprogram.model.ProgramType;

public interface ProgramTypeDAO {
	
	public ProgramType add(ProgramType programType);
	public ProgramType update(ProgramType programType);
	public void delete(ProgramType programType);
	public ProgramType get(int id);
	public List<ProgramType> getList(int offset, int limit);
	
}
