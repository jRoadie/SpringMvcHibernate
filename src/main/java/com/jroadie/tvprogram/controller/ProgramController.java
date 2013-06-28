package com.jroadie.tvprogram.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jroadie.tvprogram.model.Program;
import com.jroadie.tvprogram.service.ProgramService;

@Controller
@RequestMapping(value="/program")
public class ProgramController {
	
	@Autowired
	private ProgramService service;
	
	@Autowired
	HttpServletRequest request;
	
	@RequestMapping("/add")
	public String addProgramPage(Model m){
		m.addAttribute("program", new Program());
		m.addAttribute("pageTitle", "Add New Program");
		return "add-program";
	}
	
	@RequestMapping(value="/edit", params={"id"}, method=RequestMethod.GET)
	public String editProgramPage(@RequestParam("id") int id, Model m){
		Program program = service.getProgram(id);
		m.addAttribute("program", program);
		m.addAttribute("pageTitle", "Edit Program");
		return "edit-program";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String saveProgram(@ModelAttribute Program program, Model m){
		if(program.getId() == null) {
			service.addProgram(program);
			m.addAttribute("notice", "<p class='success'>Program successfully saved.</p>");
		} else {
			service.updateProgram(program);
			m.addAttribute("notice", "<p class='success'>Program successfully updated.</p>");
		}

		m.addAttribute("pageTitle", "Edit Program");
		
		return "edit-program";
	}
	
	@RequestMapping(value="/delete", params={"id"}, method=RequestMethod.GET)
	public String deleteProgram(@RequestParam int id, Model m) {
		service.deleteProgram(id);
		List<Program> programs = service.getProgramList(1, 10);
		m.addAttribute("programs", programs);
		m.addAttribute("notice", "Program successfully deleted");
		return "program-list";
	}
	
	@RequestMapping("/list")
	public String programListPage(Model m) {
		List<Program> programs = service.getProgramList(1, 10);
		System.out.println(programs.size());
		m.addAttribute("programs", programs);
		return "program-list";
	}
	
}
