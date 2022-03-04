package com.accenture.corso.controllers;

import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONObject;
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

import com.accenture.corso.entities.Automobile;
import com.accenture.corso.services.AutomobileService;

@RequestMapping("/automobili")
@Controller
public class AutomobileController {
	Scanner in = new Scanner(System.in);
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
	
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") Integer id, @RequestBody String automobileJSON) {
		JSONObject jo = new JSONObject(automobileJSON);
		Automobile a = new Automobile();
		a.setId(id);
		a.setModello(jo.getString("modello"));
		a.setMarca(jo.getString("marca"));
		a.setCavalli(jo.getInt("cavalli"));
		a.setCilindrata(jo.getInt("cilindrata"));
		//a.setProprietario(jo.)
		System.out.println(a);
		autoService.update(id, a);
		return "redirect:/readAutomobili";
	}
	
	@GetMapping("/getAutomobili")
	@ResponseBody
	public ArrayList<Automobile> getProprietari() {
		for(Automobile a: (ArrayList<Automobile>) autoService.readAll()) {
			System.out.println(a+"\n");
		}
		in.nextLine();
		return (ArrayList<Automobile>) autoService.readAll();
	}
}
