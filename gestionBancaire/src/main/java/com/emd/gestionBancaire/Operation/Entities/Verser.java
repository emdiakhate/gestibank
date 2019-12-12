package com.emd.gestionBancaire.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Depot")

public class Verser extends Operation {

	public Verser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Verser(Double montant, Date date_operation, Compte compte) {
		
		super(montant, date_operation, compte);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
