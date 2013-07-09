package com.jroadie.tvprogram.controller;

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
	private ProgramService programService;
	
	private static final String DETAIL_PAGE = "program-detail-form";
	private static final String LIST_PAGE = "program-list";
	
	@RequestMapping("/add")
	public String addPage(Model m){
		m.addAttribute("program", new Program());
		m.addAttribute("pageTitle", "Add New Program");
		m.addAttribute("formAction", "add");
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/edit", params={"id"}, method=RequestMethod.GET)
	public String editPage(
			@RequestParam("id") int id, 
			Model m){
		Program program = programService.get(id);
		m.addAttribute("program", program);
		m.addAttribute("pageTitle", "Edit Program");
		m.addAttribute("formAction", "edit");
		return DETAIL_PAGE;
	}
	
	@RequestMapping("/list")
	public String listPage(Model m) {
		m.addAttribute("programs", programService.getList(1, 10));
		m.addAttribute("pageTitle", "All Programs");
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(
			@ModelAttribute Program program, 
			Model m){
		
		programService.add(program);
		m.addAttribute("notice", "<p class='success'>Program successfully added.</p>");
		m.addAttribute("pageTitle", "Edit Program");
		m.addAttribute("formAction", "edit");
			
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String update(
			@ModelAttribute Program program, 
			Model m){
		
		programService.update(program);
		m.addAttribute("notice", "<p class='success'>Program successfully updated.</p>");
		m.addAttribute("pageTitle", "Edit Program");
		m.addAttribute("formAction", "edit");
		
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/delete", params={"id"}, method=RequestMethod.GET)
	public String delete(
			@RequestParam int id, 
			Model m) {
		programService.delete(id);
		m.addAttribute("notice", "<p class='warning'>Program successfully deleted</p>");
		m.addAttribute("programs", programService.getList(1, 10));
		m.addAttribute("pageTitle", "All Programs");
		return LIST_PAGE;
	}
	
}
