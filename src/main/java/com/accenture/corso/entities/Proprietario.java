package com.accenture.corso.entities;

import java.util.List;

import javax.persistence.*;

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
	@JoinTable(name="proprietario_auto",
	joinColumns = {@JoinColumn(name="id_proprietario", referencedColumnName = "id" )},
	inverseJoinColumns = {@JoinColumn(name="id_auto", referencedColumnName = "id") })
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
