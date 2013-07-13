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
	public Program add(Program program) {
		return programDAO.add(program);
	}

	@Override
	public Program update(Program program) {
		Program programToUpdate = programDAO.get(program.getId());
		programToUpdate.setCode(program.getCode());
		programToUpdate.setTitle(program.getTitle());
		programToUpdate.setDescription(program.getDescription());
		programToUpdate.setActiveStatus(program.getActiveStatus());
		programToUpdate.setScheduleSet(program.getScheduleSet());
		programToUpdate.setCategorySet(program.getCategorySet());
		return programDAO.update(programToUpdate);
	}
	
	@Override
	public void delete(int id) {
		Program programToDelete = this.get(id);
		if(programToDelete != null){
			programDAO.delete(programToDelete);
		}
	}
	
	@Override
	public Program get(int id) {
		return programDAO.get(id);
	}
	
	@Override
	public List<Program> getList(int offset, int limit) {
		return programDAO.getList(offset, limit);
	}

}
