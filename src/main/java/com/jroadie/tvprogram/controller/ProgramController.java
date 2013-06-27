package com.jroadie.tvprogram.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	public ModelAndView addProgramPage(){
		ModelAndView mnv = new ModelAndView("add-program");
		mnv.addObject("program", new Program());
		mnv.addObject("pageTitle", "Add New Program");
		return mnv;
	}
	
	@RequestMapping(value="/edit", params={"id"}, method=RequestMethod.GET)
	public ModelAndView editProgramPage(@RequestParam("id") int id){
		ModelAndView mnv = new ModelAndView("edit-program");
		Program program = service.getProgram(id);
		mnv.addObject("program", program);
		mnv.addObject("pageTitle", "Edit Program");
		return mnv;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public ModelAndView saveProgram(@ModelAttribute Program program){
		ModelAndView mnv = new ModelAndView("edit-program");
		
		if(program.getId() == null) {
			service.addProgram(program);
			mnv.addObject("notice", "<p class='success'>Program successfully saved.</p>");
		} else {
			service.updateProgram(program);
			mnv.addObject("notice", "<p class='success'>Program successfully updated.</p>");
		}

		mnv.addObject("pageTitle", "Edit Program");
		
		return mnv;
	}
	
	@RequestMapping(value="/delete", params={"id"}, method=RequestMethod.GET)
	public ModelAndView deleteProgram(@RequestParam int id) {
		ModelAndView mnv = new ModelAndView("program-list");
		service.deleteProgram(id);
		List<Program> programs = service.getProgramList(1, 10);
		mnv.addObject("programs", programs);
		mnv.addObject("notice", "Program successfully deleted");
		return mnv;
	}
	
	@RequestMapping("/list")
	public ModelAndView programListPage() {
		ModelAndView mnv = new ModelAndView("program-list");
		List<Program> programs = service.getProgramList(1, 10);
		mnv.addObject("programs", programs);
		return mnv;
	}
	
}
