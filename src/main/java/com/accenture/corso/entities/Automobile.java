package com.accenture.corso.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import lombok.*;

@Data
@Entity
@Table(name="automobili")
public class Automobile implements Comparable<Automobile>{
	/**TODO
	 * IMPLEMENTARE IL FATTO DI POTER AVERE LA FK A NULL
	 */
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
	@JoinTable(name="proprietario_auto",
				joinColumns = {@JoinColumn(name="id_auto", referencedColumnName = "id" )},
				inverseJoinColumns = {@JoinColumn(name="id_proprietario", referencedColumnName = "id") })
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
