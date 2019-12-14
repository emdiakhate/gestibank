package com.emd.gestionBancaire.User.Entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.emd.gestionBancaire.Compte.Entities.DemandeCompte;

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
