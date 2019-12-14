package com.emd.gestionBancaire.Compte.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.emd.gestionBancaire.User.Entities.Client;

@Entity
@DiscriminatorValue("SD")
public class CompteCSansDecouv extends Compte{

	public CompteCSansDecouv() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CompteCSansDecouv(Date dateCreation, Double solde, Client client) {
		super(dateCreation, solde, client);
		// TODO Auto-generated constructor stub
	}
	

}
