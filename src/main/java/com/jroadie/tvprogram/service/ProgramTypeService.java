package com.jroadie.tvprogram.service;

import java.util.List;

import com.jroadie.tvprogram.model.ProgramType;

public interface ProgramTypeService {
	
	public ProgramType add(ProgramType programType);
	public ProgramType update(ProgramType programType);
	public void delete(int id);
	public ProgramType get(int id);
	public List<ProgramType> getList(int offset, int limit);
	
}
