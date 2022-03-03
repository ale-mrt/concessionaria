package com.accenture.corso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.accenture.corso.entities.Proprietario;
import com.accenture.corso.services.ProprietarioService;

@RequestMapping("/proprietari")
@Controller
public class ProprietarioController {
	@Autowired
	private ProprietarioService propService;
	
	@GetMapping("/read")
	public String read(Model m) {
		m.addAttribute("proprietari", propService.readAll());
		
		return "readP.html";
	}
	
	@PostMapping("/create")
	public String create(@ModelAttribute("newProprietario")Proprietario p) {
		propService.create(p);
		return "redirect:/home";
	}
}
