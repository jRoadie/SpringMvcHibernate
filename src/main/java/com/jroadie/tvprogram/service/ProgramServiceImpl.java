package com.jroadie.tvprogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jroadie.tvprogram.dao.ProgramDAO;
import com.jroadie.tvprogram.model.Program;

@Service
@Transactional
public class ProgramServiceImpl implements ProgramService {
	
	@Autowired
	private ProgramDAO programDAO;

	@Override
	public Program addProgram(Program program) {
		return programDAO.addProgram(program);
	}

	@Override
	public Program updateProgram(Program program) {
		Program programToUpdate = programDAO.getProgram(program.getId());
		programToUpdate.setCode(program.getCode());
		programToUpdate.setTitle(program.getTitle());
		programToUpdate.setDescription(program.getDescription());
		programToUpdate.setStartDateTime(program.getStartDateTime());
		programToUpdate.setDuration(program.getDuration());
		programToUpdate.setActiveStatus(program.getActiveStatus());
		return programDAO.updateProgram(programToUpdate);
	}
	
	@Override
	public void deleteProgram(int id) {
		Program programToDelete = this.getProgram(id);
		if(programToDelete != null){
			programDAO.deleteProgram(programToDelete);
		}
	}
	
	@Override
	public Program getProgram(int id) {
		return programDAO.getProgram(id);
	}
	
	@Override
	public List<Program> getProgramList(int offset, int limit) {
		return programDAO.getProgramList(offset, limit);
	}

}
