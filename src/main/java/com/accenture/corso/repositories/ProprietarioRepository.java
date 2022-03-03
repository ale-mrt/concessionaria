package com.accenture.corso.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.accenture.corso.entities.Proprietario;

@Repository
public interface ProprietarioRepository  extends CrudRepository<Proprietario, Integer>{

}
