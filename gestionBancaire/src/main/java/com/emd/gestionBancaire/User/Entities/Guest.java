package com.emd.gestionBancaire.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Guest implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_guest;
	@OneToOne(mappedBy="guest")
	private DemandeCompte demande;
	
	
	public Guest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
