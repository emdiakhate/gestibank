package com.emd.gestionBancaire.Operation.Entities;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.emd.gestionBancaire.Compte.Entities.Compte;

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
