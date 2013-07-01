package com.jroadie.tvprogram.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jroadie.tvprogram.model.ProgramType;
import com.jroadie.tvprogram.service.ProgramTypeService;

@Controller
@RequestMapping("/program/type")
public class ProgramTypeController {
	
	@Autowired
	ProgramTypeService programTypeService;
	
	private static final String DETAIL_PAGE = "program-type-detail-form";
	private static final String LIST_PAGE = "program-type-list";
	
	@RequestMapping("/add")
	public String addPage(Model m) {
		m.addAttribute("programType", new ProgramType());
		m.addAttribute("pageTitle", "Add New Program Type");
		m.addAttribute("formAction", "add");
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/edit", params={"id"}, method=RequestMethod.GET)
	public String editPage(@RequestParam int id, Model m) {
		m.addAttribute("programType", programTypeService.get(id));
		m.addAttribute("pageTitle", "Edit Program Type");
		m.addAttribute("formAction", "edit");
		return DETAIL_PAGE;
	}
	
	@RequestMapping("/list")
	public String listPage(Model m){
		m.addAttribute("programTypes", programTypeService.getList(1, 10));
		m.addAttribute("pageTitle", "All Program Types");
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(
			@Valid @ModelAttribute ProgramType programType, 
			BindingResult result, 
			Model m) {
		
		if(result.hasErrors()){
			m.addAttribute("pageTitle", "Add New Program Type");
			m.addAttribute("formAction", "add");
			return DETAIL_PAGE;
		}
		
		programTypeService.add(programType);
		m.addAttribute("notice", "<p class='success'>Program Type successfully added.</p>");
		m.addAttribute("pageTitle", "Edit Program Type");
		m.addAttribute("formAction", "edit");
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String edit(
			@Valid @ModelAttribute ProgramType programType,
			BindingResult result,
			Model m) {
		
		if(result.hasErrors()){
			m.addAttribute("pageTitle", "Edit Program Type");
			m.addAttribute("formAction", "edit");
			return DETAIL_PAGE;
		}
		
		programTypeService.update(programType);
		m.addAttribute("notice", "<p class='success'>Program Type successfully updated.</p>");
		m.addAttribute("pageTitle", "Edit Program Type");
		m.addAttribute("formAction", "edit");
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam int id, Model m) {
		programTypeService.delete(id);
		m.addAttribute("programTypes", programTypeService.getList(1, 10));
		m.addAttribute("pageTitle", "All Program Types");
		m.addAttribute("notice", "<p class='warning'>Program Type successfully deleted</p>");
		return LIST_PAGE;
	}

}
