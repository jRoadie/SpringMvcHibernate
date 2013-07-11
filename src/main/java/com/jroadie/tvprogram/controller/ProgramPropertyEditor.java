package com.jroadie.tvprogram.controller;

import java.beans.PropertyEditorSupport;

import com.jroadie.tvprogram.model.Program;
import com.jroadie.tvprogram.service.ProgramService;

public class ProgramPropertyEditor extends PropertyEditorSupport {

	private ProgramService programService;
	
	protected ProgramPropertyEditor(ProgramService programService) {
		System.out.println("const");
		this.programService = programService;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		Program program = programService.get(Integer.parseInt(text));
		this.setValue(program);		
	}

}
