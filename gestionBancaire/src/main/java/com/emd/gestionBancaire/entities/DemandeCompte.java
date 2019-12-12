package com.emd.gestionBancaire.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class DemandeCompte implements Serializable {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id_demande;
	private String nom;
	private String prenom;
	private Long telephone;
	private String email;
	
	@ManyToOne
	@JoinColumn(name="id_admin")
	Admin admin = Admin.getInstanceAdmin();;
	
	@OneToOne
	@JoinColumn(name="id_guest")
	Guest guest;
	
	public DemandeCompte(String nom, String prenom, Long telephone, String email,Guest guest) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.telephone = telephone;
		this.email = email;
		this.admin.setId(1L);
		this.guest = guest;
	}
	
	public DemandeCompte() {
		super();		
	}

	public Long getId_demande() {
		return id_demande;
	}

	public void setId_demande(Long id_demande) {
		this.id_demande = id_demande;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Long getTelephone() {
		return telephone;
	}

	public void setTelephone(Long telephone) {
		this.telephone = telephone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
