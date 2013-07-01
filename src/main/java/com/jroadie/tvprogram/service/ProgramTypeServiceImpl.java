package com.jroadie.tvprogram.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jroadie.tvprogram.dao.ProgramTypeDAO;
import com.jroadie.tvprogram.model.ProgramType;

@Service
@Transactional
public class ProgramTypeServiceImpl implements ProgramTypeService {
	
	@Autowired
	ProgramTypeDAO programTypeDAO;

	@Override
	public ProgramType add(ProgramType programType) {
		return programTypeDAO.add(programType);
	}

	@Override
	public ProgramType update(ProgramType programType) {
		ProgramType programTypeToUpdate = programTypeDAO.get(programType.getId());
		programTypeToUpdate.setName(programType.getName());
		programTypeToUpdate.setDescription(programType.getDescription());
		return programTypeDAO.update(programTypeToUpdate);
	}

	@Override
	public void delete(int id) {
		ProgramType programTypeToDelete = programTypeDAO.get(id);
		if(programTypeToDelete != null){
			programTypeDAO.delete(programTypeToDelete);
		}
	}

	@Override
	public ProgramType get(int id) {
		return programTypeDAO.get(id);
	}

	@Override
	public List<ProgramType> getList(int offset, int limit) {
		return programTypeDAO.getList(offset, limit);
	}

}
