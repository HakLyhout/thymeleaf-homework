package com.template.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.template.model.User;
import com.template.service.UserService;

@Controller
public class controller {
	
	private UserService userService;
	
	@Autowired
	public controller(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping({"/admin/", "/admin/dashboard"})
	public String addViewControllers(ModelMap model){
		model.addAttribute("LINK","/admin/dashboard");
		model.addAttribute("totaluser", userService.getAllUsers().size());
		model.addAttribute("maleuser", userService.countUsersByGender("M"));
		model.addAttribute("femaleuser", userService.countUsersByGender("F"));
		return "admin/dashboard";
	}
	@RequestMapping({"/admin/user-list"})
	public String userList(ModelMap model){
		model.addAttribute("LINK", "/admin/user-list");
		model.addAttribute("USERS", userService.getAllUsers());
		return "admin/user-list";
	}
	@RequestMapping({"admin/{userHash}/userprofile"})
	public String userProfile(@PathVariable String userHash, ModelMap model){
		model.addAttribute("LINK","/admin/userprofile");
		model.addAttribute("USERS", userService.getUserByHash(userHash));
		return "admin/userprofile";
		
	}
	@RequestMapping("/user/{user_hash}/delete")
	public ModelAndView delete(@PathVariable("user_hash") String userHash){
		userService.deleteUser(userHash);
		return new ModelAndView("redirect:/admin/user-list");
	}
	
	
	@RequestMapping({"/admin/user-cu"})
	public String userCu(ModelMap model){
		model.addAttribute("USER", new User());
		model.addAttribute("LINK","/admin/user-cu");
		return "admin/user-cu";
		
	}
	@RequestMapping(value="/api/user/update", method=RequestMethod.POST)
	public ModelAndView updateUser(@ModelAttribute User user){
		System.out.println("sdfsdfsdf " + user.getUserHash());
		userService.updateUser(user);
		return new ModelAndView("redirect:/admin/user-list");
	}
	
	
	@RequestMapping({"/user/{user_hash}/update"})
	public String update(@PathVariable("user_hash") String userHash, ModelMap model){
		model.addAttribute("USER", userService.getUserByHash(userHash));
		return "admin/user-update";
	}
	
	
	//save user
	@RequestMapping(value="/api/user/create", method=RequestMethod.POST)
	public ModelAndView userCreate(@ModelAttribute User user){
		userService.saveUser(user);
		return new ModelAndView("redirect:/admin/user-list");
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
