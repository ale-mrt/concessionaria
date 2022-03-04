package com.accenture.corso.services;

import java.util.ArrayList;
import java.util.Collections;

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
	
	public boolean create(Proprietario p) {
		try {
			proprietarioRepo.save(p);
			return true;
		}catch(Exception e) {
			System.out.println("non sono riuscito a creare il proprietario '" + p.nomeCognome() + "'");
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean delete(Integer id) {
		try {
			if(proprietarioRepo.existsById(id)) {
				proprietarioRepo.delete(proprietarioRepo.findById(id).get());
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			System.out.println("non sono riuscito a eliminare il proprietario con id " + id);
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean update(Integer id, Proprietario p) {
		try {
			if(proprietarioRepo.existsById(id)) {
				proprietarioRepo.save(p);
				return true;
			}else {
				return false;
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("non sono riuscito a modificare il proprietario con id " + id);
			return false;
		}
	}
	public Proprietario getById(Integer id) {
		return proprietarioRepo.findById(id).get();
	}
}