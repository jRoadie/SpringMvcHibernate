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

import com.jroadie.tvprogram.model.Category;
import com.jroadie.tvprogram.service.CategoryService;

@Controller
@RequestMapping("/program/category")
public class CategoryController {
	
	@Autowired
	CategoryService categoryService;
	
	private static final String DETAIL_PAGE = "category-detail-form";
	private static final String LIST_PAGE = "category-list";
	
	@RequestMapping("/add")
	public String addPage(Model m) {
		m.addAttribute("category", new Category());
		m.addAttribute("pageTitle", "Add New Category");
		m.addAttribute("formAction", "add");
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/edit", params={"id"}, method=RequestMethod.GET)
	public String editPage(@RequestParam int id, Model m) {
		m.addAttribute("category", categoryService.get(id));
		m.addAttribute("pageTitle", "Edit Category");
		m.addAttribute("formAction", "edit");
		return DETAIL_PAGE;
	}
	
	@RequestMapping("/list")
	public String listPage(Model m){
		m.addAttribute("categories", categoryService.getList(1, 10));
		m.addAttribute("pageTitle", "All Categories");
		return LIST_PAGE;
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String add(
			@ModelAttribute Category category, 
			Model m) {
		
		categoryService.add(category);
		m.addAttribute("notice", "<p class='success'>Category successfully added.</p>");
		m.addAttribute("pageTitle", "Edit Category");
		m.addAttribute("formAction", "edit");
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/edit", method=RequestMethod.POST)
	public String edit(
			@Valid @ModelAttribute Category category,
			BindingResult result,
			Model m) {
		
		if(result.hasErrors()){
			m.addAttribute("pageTitle", "Edit Program Category");
			m.addAttribute("formAction", "edit");
			return DETAIL_PAGE;
		}
		
		categoryService.update(category);
		m.addAttribute("notice", "<p class='success'>Program Category successfully updated.</p>");
		m.addAttribute("pageTitle", "Edit Program Category");
		m.addAttribute("formAction", "edit");
		return DETAIL_PAGE;
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(@RequestParam int id, Model m) {
		categoryService.delete(id);
		m.addAttribute("categories", categoryService.getList(1, 10));
		m.addAttribute("pageTitle", "All Program Categories");
		m.addAttribute("notice", "<p class='warning'>Category successfully deleted</p>");
		return LIST_PAGE;
	}

}
