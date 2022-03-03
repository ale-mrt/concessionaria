package com.accenture.corso.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.corso.entities.Proprietario;
import com.accenture.corso.repositories.ProprietarioRepository;

@Service
public class ProprietarioService {
	@Autowired
	private ProprietarioRepository proprietarioRepo;
	
	public Iterable<Proprietario> readAll(){
		ArrayList<Proprietario> proprietari = (ArrayList<Proprietario>) proprietarioRepo.findAll();
		Collections.sort(proprietari);
		
		return proprietari;
	}
	
	public Optional<Proprietario> readById(Integer id) {
		return proprietarioRepo.findById(id);
	}
	
	public boolean create(Proprietario a) {
		try {
			proprietarioRepo.save(a);
			return true;
		}catch(Exception e) {
			System.out.println("non sono riuscito a creare l'automobile");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Proprietario a, Integer id) {
		try {
			proprietarioRepo.deleteById(id);
			proprietarioRepo.save(a);
			return true;
		}catch(Exception e) {
			System.out.println("non sono riuscito a creare l'automobile");
			e.printStackTrace();
			return false;
		}
	}

	public boolean delete(Proprietario a) {
		try {
			proprietarioRepo.delete(a);
			return true;
		}catch(Exception e) {
			System.out.println("non sono riuscito a cancellare l'automobile");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteById(Proprietario a) {
		try {
			proprietarioRepo.deleteById(a.getId());
			return true;
		}catch(Exception e) {
			System.out.println("non sono riuscito a cancellare l'automobile");
			e.printStackTrace();
			return false;
		}
	}
}