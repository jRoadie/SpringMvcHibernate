package com.jroadie.tvprogram.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jroadie.tvprogram.model.Program;
import com.jroadie.tvprogram.model.Schedule;
import com.jroadie.tvprogram.service.ProgramService;
import com.jroadie.tvprogram.service.ScheduleService;

@Controller
@RequestMapping("/program/schedule")
public class ScheduleController {
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private ProgramService programService;
	
	private static final String DETAIL_PAGE = "schedule-detail-form";
	private static final String LIST_PAGE = "schedule-list";
	
	@RequestMapping("/add")
	public String addPage(Model m) {
		m.addAttribute("schedule", new Schedule());
		m.addAttribute("pageTitle", "Add New Schedule");
		m.addAttribute("formAction", "add");
		m.addAttribute("programs", programService.getList(1, -1));
		//m.addAttribute("programMap", this.getAllProgramsMap());
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/edit", params={"id"}, method=RequestMethod.GET)
	public String editPage(
			@RequestParam("id") int id, 
			Model m) {
		
		Schedule schedule = scheduleService.get(id);
		m.addAttribute("schedule", schedule);
		m.addAttribute("pageTitle", "Edit Schedule");
		m.addAttribute("formAction", "edit");
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/list")
	public String listPage(Model m) {
		m.addAttribute("schedules", scheduleService.getList(1, 10));
		m.addAttribute("pageTitle", "All Schedule");
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(
			@ModelAttribute("program") Integer program,
			@ModelAttribute("schedule") Schedule schedule,
			Model m) {
		System.out.println("add-action");
		scheduleService.add(schedule);
		m.addAttribute("notice", "<p class='success'>Schedule successfully added.</p>");
		m.addAttribute("pageTitle", "Edit Schedule");
		m.addAttribute("formAction", "edit");
		m.addAttribute("programs", programService.getList(1, -1));
		//m.addAttribute("programMap", this.getAllProgramsMap());
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String update(
			@ModelAttribute Schedule schedule,
			Model m) {
		
		scheduleService.update(schedule);
		m.addAttribute("notice", "<p class='success'>Schedule successfully updated.</p>");
		m.addAttribute("pageTitle", "Edit Schedule");
		m.addAttribute("formAction", "edit");

		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/delete", params={"id"}, method=RequestMethod.GET)
	public String delete(
			@RequestParam("id") int id,
			Model m) {
		
		scheduleService.delete(id);
		m.addAttribute("notice", "<p class='warning'>Schedule successfully deleted</p>");
		m.addAttribute("schedules", scheduleService.getList(1, 10));
		m.addAttribute("pageTitle", "All Schedule");
		return LIST_PAGE;
	}
	
	private Map<Integer, String> getAllProgramsMap(){
		Map<Integer, String> programMap = new HashMap<Integer, String>();
		List<Program> programList = programService.getList(1, -1);
		//System.out.println("programList size: "+programList.size());
		for(Program p:programList) {
			programMap.put(p.getId(), p.getTitle());
		}
		//System.out.println("programMap size: "+programMap.size());
		return programMap;
	}
}
