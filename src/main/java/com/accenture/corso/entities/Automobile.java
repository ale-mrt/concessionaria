package com.accenture.corso.entities;

import javax.persistence.*;
import lombok.Data;

@Data
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
	
	@Override
	public int compareTo(Automobile o) {
		if(this.id > o.getId()) {
			return 1;
		}else {
			return -1;
		}
	}
}
