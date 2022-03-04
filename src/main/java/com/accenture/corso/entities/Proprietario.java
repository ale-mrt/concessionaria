package com.accenture.corso.entities;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.Data;

@Data
@Entity
@Table(name="proprietari")
public class Proprietario implements Comparable<Proprietario>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	
	@OneToMany
	private List<Automobile> automobili;
	
	@Override
	public int compareTo(Proprietario o) {
		if(this.id > o.getId()) {
			return 1;
		}else {
			return -1;
		}
	}
	
	public String nomeCognome() {
		return nome + " " + cognome;
	}
}
