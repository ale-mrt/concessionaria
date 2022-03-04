package com.accenture.corso.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.accenture.corso.entities.Automobile;
import com.accenture.corso.entities.Proprietario;

@Controller
public class HomeController {
	@GetMapping({"", "/", "/home.html", "/index.html", "/index", "/home"})
	public String home() {  
		return "homeConcessionaria.html";
	}
	
	@GetMapping({"/readAutomobili", "/readAutomobili.html"})
	public String readAutomobili() {
		return "readA.html";
	}
	
	@GetMapping({"/readProprietari", "/readProprietari.html"})
	public String readProprietari() {
		return "readP.html";
	}
	
	@GetMapping({"/createAutomobili", "/createAutomobili.html"}) 
	public String createAutomobili(Model m) {
		m.addAttribute("newAutomobile", new Automobile());
	    return "createA.html";
	}

	@GetMapping({"/createProprietari", "/createProprietari.html"})
	public String createProprietari(Model m) {
		m.addAttribute("newProprietario", new Proprietario());
	    return "createP.html";
	}
	
	@GetMapping({"/updateProprietario", "/updateProprietaro.html"})
	public String updateProprietario(Model m) {
	    return "updateP.html";
	}
	
	@GetMapping({"/updateAutomobile", "/updateAutomobile.html"})
	public String updateAutomobile() {
		
	    return "updateA.html";
	}
}
