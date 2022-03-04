package com.accenture.corso.controllers;

import java.util.ArrayList;

import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		return "redirect:/readProprietari";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		propService.delete(id);
		return "redirect:/readProprietari"; 
	}
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Integer id, @RequestBody String proprietarioJSON) {
		JSONObject jo = new JSONObject(proprietarioJSON);
		Proprietario p = new Proprietario();
		
		p.setId(id);
		p.setNome(jo.getString("nome"));
		p.setCognome(jo.getString("cognome"));
		
		System.out.println(p);
		propService.update(id, p);
		return "redirect:/readProprietari";
	}
	
	@GetMapping("/getProprietari")
	@ResponseBody
	public ArrayList<Proprietario> getProprietari() {
		
		return (ArrayList<Proprietario>) propService.readAll();
	}
}
