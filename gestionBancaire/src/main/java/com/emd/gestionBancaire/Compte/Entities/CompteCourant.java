package com.emd.gestionBancaire.Compte.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.emd.gestionBancaire.User.Entities.Client;


@Entity
@DiscriminatorValue("CC")
public class CompteCourant extends Compte {
	
	private Double decouvert;

	public CompteCourant() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCourant(Date dateCreation, Double solde, Client client, Double decouvert) {
		super(dateCreation, solde, client);
		this.decouvert = decouvert;
		
		
	}

	public Double getDecouvert() {
		return decouvert;
	}

	public void setDecouvert(Double decouvert) {
		this.decouvert = decouvert;
	}
	
	
	

}
