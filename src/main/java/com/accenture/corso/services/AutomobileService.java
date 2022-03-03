package com.accenture.corso.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.corso.entities.Automobile;
import com.accenture.corso.repositories.AutomobileRepository;

@Service
public class AutomobileService {
	@Autowired
	private AutomobileRepository autoRepo;
	
	public Iterable<Automobile> readAll(){
		ArrayList<Automobile> automobili = (ArrayList<Automobile>) autoRepo.findAll();
		Collections.sort(automobili);
		
		return automobili;
	}
	
	public Optional<Automobile> readById(Integer id) {
		return autoRepo.findById(id);
	}
	
	public boolean create(Automobile a) {
		try {
			autoRepo.save(a);
			return true;
		}catch(Exception e) {
			System.out.println("non sono riuscito a creare l'automobile");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Integer id) {
		try {
			Automobile a = autoRepo.findById(id).get();
			autoRepo.save(a);
			return true;
		}catch(Exception e) {
			System.out.println("non sono riuscito a creare l'automobile");
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Automobile a) {
		try {
			autoRepo.delete(a);
			return true;
		}catch(Exception e) {
			System.out.println("non sono riuscito a cancellare l'automobile");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteById(Automobile a) {
		try {
			autoRepo.deleteById(a.getId());
			return true;
		}catch(Exception e) {
			System.out.println("non sono riuscito a cancellare l'automobile");
			e.printStackTrace();
			return false;
		}
	}
}
