package com.emd.gestionBancaire.User.Entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.emd.gestionBancaire.Compte.Entities.Compte;

@Entity
public class Client implements Serializable{
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_client;
	private String nom_client;
	private String prenom_client;
	private String password_client;
	private String login_client;
	
	@OneToMany(mappedBy = "client")
	private Collection<Compte> comptes;
	@ManyToOne
	@JoinColumn(name="id_agent")
	private Agent agent;
	
	public Client() {
		super();
	}
	public Client(String nom, String prenom, Agent agent) {
		super();
		this.nom_client = nom;
		this.prenom_client = prenom;
		this.agent = agent;
	}
	
	public Long getId_client() {
		return id_client;
	}
	public void setId_client(Long id) {
		this.id_client = id;
	}
	public String getNom() {
		return nom_client;
	}
	public void setNom(String nom) {
		this.nom_client = nom;
	}
	
	public String getPrenom() {
		return prenom_client;
	}
	public void setPrenom(String prenom) {
		this.prenom_client = prenom;
	}
	public String getPassword_client() {
		return password_client;
	}
	public void setPassword_client(String password_client) {
		this.password_client = password_client;
	}
	public String getLogin() {
		return login_client;
	}
	public void setLogin(String login) {
		this.login_client = login;
	}
	
	
	
}
