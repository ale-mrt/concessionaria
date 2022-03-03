package com.accenture.corso.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accenture.corso.entities.Automobile;

@Repository
public interface AutomobileRepository extends CrudRepository<Automobile, Integer>{

}
