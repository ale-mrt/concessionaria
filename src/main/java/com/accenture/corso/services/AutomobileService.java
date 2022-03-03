package com.accenture.corso.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.corso.repositories.AutomobileRepository;

@Service
public class AutomobileService {
	@Autowired
	private AutomobileRepository autoRepo;
}
