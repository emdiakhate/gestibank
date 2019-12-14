package com.emd.gestionBancaire.Compte.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.emd.gestionBancaire.User.Entities.Client;


@Entity
@DiscriminatorValue("CE")
public class CompteEpargne extends Compte {
	
	private Double taux;

	public CompteEpargne( Date dateCreation, Double solde, Client client, Double taux) {
		super(dateCreation, solde, client);
		this.taux = taux;
		
	}

	
	
	public CompteEpargne() {
		super();
		
	}



	public Double getTaux() {
		return taux;
	}

	public void setTaux(Double taux) {
		this.taux = taux;
	}
		
	
}
