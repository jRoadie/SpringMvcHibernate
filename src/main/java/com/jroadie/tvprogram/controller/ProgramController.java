package com.jroadie.tvprogram.controller;

import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.xml.ws.BindingType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
		m.addAttribute("formAction", "add");
		return "program-detail-form";
	}
	
	@RequestMapping(value="/edit", params={"id"}, method=RequestMethod.GET)
	public String editProgramPage(@RequestParam("id") int id, Model m){
		Program program = service.getProgram(id);
		m.addAttribute("program", program);
		m.addAttribute("pageTitle", "Edit Program");
		m.addAttribute("formAction", "edit");
		return "program-detail-form";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String addProgram(
			@Valid @ModelAttribute Program program, 
			BindingResult result, 
			Model m){
		
		if(result.hasErrors()){
			m.addAttribute("pageTitle", "Add Program");
			m.addAttribute("formAction", "add");
			return "program-detail-form";
		}
		
		service.addProgram(program);
		m.addAttribute("notice", "<p class='success'>Program successfully added.</p>");
		m.addAttribute("pageTitle", "Edit Program");
		m.addAttribute("formAction", "edit");
			
		return "program-detail-form";
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String updateProgram(
			@Valid @ModelAttribute Program program, 
			BindingResult result, 
			Model m){
		
		m.addAttribute("pageTitle", "Edit Program");
		m.addAttribute("formAction", "edit");
		
		if(result.hasErrors()){
			return "program-detail-form";
		}
		
		service.updateProgram(program);
		m.addAttribute("notice", "<p class='success'>Program successfully updated.</p>");
			
		return "program-detail-form";
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
