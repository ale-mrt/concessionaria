package com.accenture.corso.entities;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import lombok.*;

@Getter
@Setter
@Entity
@Table(name="automobili")
public class Automobile implements Comparable<Automobile>{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "modello")
	private String modello;
	@Column(name = "marca")
	private String marca;
	@Column(name = "cavalli")
	private int cavalli;
	@Column(name = "cilindrata")
	private int cilindrata;
	@ManyToOne
	@JoinColumn(name="proprietario_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Proprietario proprietario;
	
	@Override
	public int compareTo(Automobile o) {
		if(this.id > o.getId()) {
			return 1;
		}else {
			return -1;
		}
	}
	
	public String getInfoProprietario() {
		return this.proprietario.nomeCognome();
	}
	
	@Override
	public String toString() {
		return "Automobile [id=" + id + ", modello=" + modello + ", marca=" + marca + ", cavalli=" + cavalli
				+ ", cilindrata=" + cilindrata + ", proprietario=" + proprietario.nomeCognome() + "]";
	}
	
	
		
	
}
