package com.emd.gestionBancaire.Compte.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.emd.gestionBancaire.Compte.Entities.Compte;
import com.emd.gestionBancaire.Compte.Services.IGestiBank;
import com.emd.gestionBancaire.User.DAO.ClientRepository;


@CrossOrigin()
@RestController

public class GestiController {
	
	@Autowired
	IGestiBank gestiMetier;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@GetMapping(value="/comptes", produces = "application/json")
	public List<Compte> ConsulterAllCompte() {	
		return gestiMetier.ConsulterAllCompte();
	}
	
	@GetMapping(value="/comptes/{id}")
	public Compte consulterUnCompte(@PathVariable Long id)
	{	
		return gestiMetier.ConsulterCompte(id);
	}
	
	@GetMapping(value="/retrait/{id}")
	public Compte retrait(@PathVariable Long id)
	{
		gestiMetier.Retrait(id, 1000.0);
		
		return consulterUnCompte(id);
	}
	
	@GetMapping(value="/supprimeragent/{id}")
	public void supprimerAgent(@PathVariable Long id) {
		gestiMetier.supprimerAgent(id);
	}
	
	/*
	@GetMapping(value="/clientNom")
	public List<Client> afficher() {
	return clientRepository.findByNom();
	}*/
}
