package com.met.domaci.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.met.domaci.entities.Ispit;
import com.met.domaci.entities.User;
import com.met.domaci.service.IspitServiceImpl;
import com.met.domaci.service.UserServiceImpl;

@Controller
@RequestMapping("/student")
public class IspitController {
	
	@Autowired
	private UserServiceImpl userService;

	@Autowired
	private IspitServiceImpl ispitService;
	
	@GetMapping("/home")
	public ModelAndView home() {
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());

		model.addObject("user", user);
		model.addObject("userName", "Dobro dosli " + user.getFirstName() + " " + user.getLastName() + " (" + user.getUserName() + ")");
		model.addObject("ispit", new Ispit());

		Set<Ispit> ispiti =  new HashSet<>(ispitService.listAllIspiti());
		ispiti.removeAll(user.getIspiti());
		if (!ispiti.isEmpty()) {
			model.addObject("ispiti", ispiti);
		}

		model.setViewName("student/home");
		return model;
	}
	
	@GetMapping("/dodatiIspiti")
	public ModelAndView dodatiIspiti(){
		ModelAndView model = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());

		model.addObject("user", user);
		
		Set<Ispit> ispiti = user.getIspiti();
		
		if (!ispiti.isEmpty()) {
			model.addObject("ispiti", ispiti);
			
		}
		model.setViewName("student/dodatiIspiti");
		return model;
	}
    
	@GetMapping("/courses/{id}/update")
	public String showUpdateUserForm(@PathVariable("id") String id, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		
		Ispit ispit = ispitService.findOne(Integer.valueOf(id));
		
		user.getIspiti().add(ispit);
		
		userService.save(user);

		model.addAttribute("user", user);
		model.addAttribute("ispiti", user.getIspiti());
		return "redirect:/student/home";

	}
	
	@GetMapping("/courses/{id}/update/odjavi")
	public String showUpdateUserFormLaterDelete(@PathVariable("id") String id, Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByUserName(auth.getName());
		
		Ispit ispit = ispitService.findOne(Integer.valueOf(id));
		
		user.getIspiti().remove(ispit);
		
		userService.save(user);

		model.addAttribute("user", user);
		model.addAttribute("ispiti", user.getIspiti());
		return "redirect:/student/dodatiIspiti";

	}
}
