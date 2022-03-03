package com.accenture.corso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.corso.entities.Automobile;
import com.accenture.corso.services.AutomobileService;

@RequestMapping("/automobili")
@Controller
public class AutomobileController {
	@Autowired
	private AutomobileService autoService;
	
	@GetMapping("/read")
	public String read(Model m) {
		m.addAttribute("automobili", autoService.readAll());
		
		return "readA.html";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("newAutomobile")Automobile a) {
		autoService.create(a);
		return "redirect:/home";
	}
	
	@PostMapping("/update")
	public String update(@ModelAttribute("autmobileId")Integer id) {
		autoService.update(id);
		return "redirect:/home";
	}
}
