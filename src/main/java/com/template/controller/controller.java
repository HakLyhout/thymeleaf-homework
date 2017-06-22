package com.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
	@RequestMapping({"/admin/", "/admin/dashboard"})
	public String addViewControllers(ModelMap model){
		model.addAttribute("LINK","/admin/dashboard");
		return "admin/dashboard";
	}
	@RequestMapping({"/admin/user-list"})
	public String userList(ModelMap model){
		model.addAttribute("LINK","/admin/user-list");
		return "admin/user-list";
		
	}
	@RequestMapping({"/admin/user-cu"})
	public String userCu(ModelMap model){
		model.addAttribute("LINK","/admin/user-cu");
		return "admin/user-cu";
		
	}
	@RequestMapping({"/admin/role-list"})
	public String roleList(ModelMap model){
		model.addAttribute("LINK","/admin/role-list");
		return "admin/role-list";
		
	}
	@RequestMapping({"/admin/role-cu"})
	public String roleCu(ModelMap model){
		model.addAttribute("LINK","/admin/role-cu");
		return "admin/role-cu";
		
	}
	
}
