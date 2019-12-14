package com.emd.gestionBancaire.Compte.Entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.emd.gestionBancaire.Operation.Entities.Operation;
import com.emd.gestionBancaire.User.Entities.Client;



@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_COMPTE", discriminatorType= DiscriminatorType.STRING, length=2)

public abstract class Compte implements Serializable{
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numeroCompte;
	private Date dateCreation;
	private Double solde;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	@OneToMany(mappedBy="compte", fetch=FetchType.LAZY)
	private Collection<Operation> operations;
	
	
	public Compte(Date dateCreation, Double solde, Client client) {
		super();
		this.dateCreation = dateCreation;
		this.solde = solde;
		this.client = client;
	}


	public Compte() {
		super();
	}


	public Long getNumeroCompte() {
		return numeroCompte;
	}


	public void setNumeroCompte(Long numeroCompte) {
		this.numeroCompte = numeroCompte;
	}


	public Date getDateCreation() {
		return dateCreation;
	}


	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}


	public Double getSolde() {
		return solde;
	}


	public void setSolde(Double solde) {
		this.solde = solde;
	}


	public Collection<Operation> getOperations() {
		return operations;
	}


	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}


	public Client getClient() {
		return client;
	}


	public void setClient(Client client) {
		this.client = client;
	}


	@Override
	public String toString() {
		return "Compte [numeroCompte=" + numeroCompte + ", dateCreation=" + dateCreation + ", solde=" + solde
				+ ", client=" + client + ", operations=" + operations + "]";
	}
	
	

}
