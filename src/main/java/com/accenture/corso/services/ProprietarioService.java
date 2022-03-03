package com.accenture.corso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.corso.repositories.ProprietarioRepository;

@Service
public class ProprietarioService {
	@Autowired
	private ProprietarioRepository proprietarioRepo;
}