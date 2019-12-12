package com.emd.gestionBancaire.metier;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.emd.gestionBancaire.DAO.AdminRepository;
import com.emd.gestionBancaire.DAO.AgentRepository;
import com.emd.gestionBancaire.DAO.ClientRepository;
import com.emd.gestionBancaire.DAO.CompteRepository;
import com.emd.gestionBancaire.DAO.DemandeRepository;
import com.emd.gestionBancaire.DAO.OperationRepository;
import com.emd.gestionBancaire.entities.Admin;
import com.emd.gestionBancaire.entities.Agent;
import com.emd.gestionBancaire.entities.Client;
import com.emd.gestionBancaire.entities.Compte;
import com.emd.gestionBancaire.entities.CompteCSansDecouv;
import com.emd.gestionBancaire.entities.CompteCourant;
import com.emd.gestionBancaire.entities.DemandeCompte;
import com.emd.gestionBancaire.entities.Operation;
import com.emd.gestionBancaire.entities.Retirer;
import com.emd.gestionBancaire.entities.Verser;

@Service
@Transactional
public class GestiBankMetier implements IGestiBank {
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AgentRepository agentRepository;
	@Autowired
	private OperationRepository operationRepository;
	@Autowired
	private CompteRepository compteRepository;
	@Autowired
	private AdminRepository adminRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	
	
	
	@Override
	public List<Compte> ConsulterAllCompte() {	
		return compteRepository.findAll();
	}
	
	@Override
	public Compte ConsulterCompte(Long id_compte) {	
		return compteRepository.findOne(id_compte);
	}
	
	/****************** A corriger****************/
	@Override
	public void Retrait(Long idCompte, Double montant) {
		
		Compte compte = ConsulterCompte(idCompte);
		
		Double faciliteCaisse = 0.0;  
		if (compte instanceof CompteCourant)
			faciliteCaisse = ((CompteCourant) compte).getDecouvert(); 
		
		if (compte instanceof CompteCourant || compte instanceof CompteCSansDecouv)
		{
			if (montant <= compte.getSolde() + faciliteCaisse )	
			{	
				compte.setSolde(compte.getSolde() - montant);
				compteRepository.save(compte);
				Retirer retirer = new Retirer(montant, new Date(), compte);
				operationRepository.save(retirer);
			}
			else
			{
				System.out.println("Solde insuffisant pour cette opération");
			}
		
		}
		
	}

	@Override
	public void Depot(Long idCompte, Double montant) {
		Compte compte = ConsulterCompte(idCompte);
		
		compte.setSolde(compte.getSolde() + montant);
		compteRepository.save(compte);
		
		Verser verser = new Verser(montant, new Date(), compte);
		operationRepository.save(verser);
		
	}

	@Override
	public void Virement(Long idCompteEnvoyeur, Long idCompteReceveur, Double montant) {
		
		Depot(idCompteReceveur, montant);
		Retrait(idCompteEnvoyeur, montant);
			
	}
	
	@Override
	public Page<Operation> ListOperation(Long idCompte, int page, int size) {
		return operationRepository.listOperation(idCompte, new PageRequest(page, size));
	}

	@Override
	public void creerAgent(String nom, String prenom) {
		
		agentRepository.save(new Agent(nom, prenom));
		
	}

	@Override
	public void supprimerAgent(Long id_agent) {
		if (agentRepository.exists(id_agent))
		{
			Agent agent = agentRepository.findOne(id_agent);
			agentRepository.delete(agent);
		}		
	}
	
	/*A vérifier que les données sont mises à jour*/
	@Override
	public void editerAgent(Long id_agent) {
		
		Agent agent = agentRepository.findOne(id_agent);
		agentRepository.save(agent);
	}

	@Override
	public void ajouterDemandeCompte(DemandeCompte demande) {	
		demandeRepository.save(demande);
	}
	
	/*Algo à definir*/
	@Override
	public void affecterDemandeCompte(Long id_demande, Long id_agent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validerDemande(DemandeCompte demande) {
		
		ajouterDemandeCompte(demande);
	}
	
	
	
	@Override
	public Client chercherClient(Long id_client) {	
		return clientRepository.findOne(id_client);
	}
	
	/*A corriger affecter client à agent*/
	@Override
	public void creerClient(Long id_demande, Long id_agent) {
		Agent agent = agentRepository.findOne(id_agent);
		
		DemandeCompte demande = demandeRepository.findOne(id_demande);
		Client client= new Client(
				demande.getNom(),
				demande.getPrenom(),
				agent);
		
		clientRepository.save(client);
		
		demandeRepository.delete(demande);
		
	}
	
	@Override
	public Collection<Client> getListClient(Long id_agent) {
		
		return clientRepository.listClient(id_agent);
	}

	@Override
	public void getListClientByMC() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editerClient(Long idClient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Operation> getListOperationClientsByDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void commanderChequier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void notificationOperation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void validerDemandeChequier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Operation> getListOperationByDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void imprimerOperation() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void consulterDevise(Double montant, String devise, String devAconvertir) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DemandeCompte demandeOuvertureCompte() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
