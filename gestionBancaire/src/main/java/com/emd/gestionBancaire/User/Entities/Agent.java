package com.emd.gestionBancaire.User.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/*Création de la table Agent dans la BD*/
@Entity
public class Agent implements Serializable {
	/*Les différents informations de la table Agent*/
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_agent;
	private String nom_agent;
	private String prenom_agent;
	private String password_agent;
	private String login_agent;

	/*Manage agent's list*/
	@OneToMany(mappedBy="agent", fetch=FetchType.LAZY)
	private Collection<Client> clients = null;
	
	@ManyToOne
	@JoinColumn(name="id_admin")
	private Admin admin= Admin.getInstanceAdmin();
	
	/*Constructor*/
	public Agent(String nom_agent, String prenom_agent) {
		super();
		this.nom_agent = nom_agent;
		this.prenom_agent = prenom_agent;
		this.admin.setId(1L);
	}
	
	public Agent() {
		super();
		
	}

	public Long getId_agent() {
		return id_agent;
	}

	public void setId_agent(Long id_agent) {
		this.id_agent = id_agent;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public String getNom_agent() {
		return nom_agent;
	}

	public void setNom_agent(String nom_agent) {
		this.nom_agent = nom_agent;
	}

	public String getPrenom_agent() {
		return prenom_agent;
	}

	public void setPrenom_agent(String prenom_agent) {
		this.prenom_agent = prenom_agent;
	}

	public Collection<Client> getClients() {
		return clients;
	}

	
	
	
}
