package com.emd.gestionBancaire.entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("retrait")

public class Retirer extends Operation {
	
	
	public Retirer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Retirer(Double montant, Date date_operation, Compte compte) {
		
		super(montant, date_operation, compte);
		// TODO Auto-generated constructor stub
	}
}
