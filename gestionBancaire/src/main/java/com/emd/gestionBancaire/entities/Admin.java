package com.emd.gestionBancaire.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Admin implements Serializable {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private  String login;
	private String password;
	@OneToMany(mappedBy="admin")
	private Collection<Agent> agent;
	
	@OneToMany(mappedBy="admin")
	private Collection<DemandeCompte> demandeCompte;
	
	
	private Admin() {
		super();
		this.login = "admin";
		this.password = "password";
	}
	
	
	public static Admin getInstanceAdmin() {
		return new Admin();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public Collection<Agent> getAgent() {
		return agent;
	}


	public void setAgent(Collection<Agent> agent) {
		this.agent = agent;
	}


	public Collection<DemandeCompte> getDemandeCompte() {
		return demandeCompte;
	}


	public void setDemandeCompte(Collection<DemandeCompte> demandeCompte) {
		this.demandeCompte = demandeCompte;
	}
	
	
	
}
