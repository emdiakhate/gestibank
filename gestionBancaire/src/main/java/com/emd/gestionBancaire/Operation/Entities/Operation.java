package com.emd.gestionBancaire.Operation.Entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.emd.gestionBancaire.Compte.Entities.Compte;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_operation", discriminatorType=DiscriminatorType.STRING, length=7)

public abstract class Operation implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numéro;
	private Double montant;
	private Date date_operation;
	@ManyToOne
	@JoinColumn(name="id_compte")
	private Compte compte;
	
	
	
	
	public Operation() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Operation(Double montant, Date date_operation, Compte compte) {
		super();
		this.montant = montant;
		this.date_operation = date_operation;
		this.compte = compte;
	}
	
	
	
}
