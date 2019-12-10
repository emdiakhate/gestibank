package com.emd.gestionBancaire;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.emd.gestionBancaire.DAO.AdminRepository;
import com.emd.gestionBancaire.DAO.AgentRepository;
import com.emd.gestionBancaire.DAO.ClientRepository;
import com.emd.gestionBancaire.DAO.CompteRepository;
import com.emd.gestionBancaire.DAO.DemandeRepository;
import com.emd.gestionBancaire.DAO.GuestRepository;
import com.emd.gestionBancaire.DAO.OperationRepository;
import com.emd.gestionBancaire.entities.Admin;
import com.emd.gestionBancaire.entities.Agent;
import com.emd.gestionBancaire.entities.Client;
import com.emd.gestionBancaire.entities.Compte;
import com.emd.gestionBancaire.entities.CompteCSansDecouv;
import com.emd.gestionBancaire.entities.CompteCourant;
import com.emd.gestionBancaire.entities.CompteEpargne;
import com.emd.gestionBancaire.entities.DemandeCompte;
import com.emd.gestionBancaire.entities.Guest;
import com.emd.gestionBancaire.entities.Retirer;
import com.emd.gestionBancaire.entities.Verser;
import com.emd.gestionBancaire.metier.IGestiBank;

@SpringBootApplication
public class GestionBancaireApplication implements CommandLineRunner {
	
	@Bean
	public CorsFilter corsFilter() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

	    final CorsConfiguration config = new CorsConfiguration();
	    config.setAllowCredentials(true);
	    config.setAllowedOrigins(Collections.singletonList("*"));
	    config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept"));
	    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

	    source.registerCorsConfiguration("/**", config);
	    return new CorsFilter(source);
	}
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
	@Autowired
	private GuestRepository guestRepository;
	@Autowired
	private IGestiBank bankMetier;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionBancaireApplication.class, args);
		
	}

	@Override
	public void run(String... arg0) throws Exception {
		
		/*
	
		Admin admin = Admin.getInstanceAdmin();
	adminRepository.save(admin);
		
		Agent a1= agentRepository.save(new Agent("Diakahate", "Malick"));
		Agent a2= agentRepository.save(new Agent("dia", "Hamza"));
		Agent a3= agentRepository.save(new Agent("Fall", "Binetou"));
		Agent a4= agentRepository.save(new Agent("seck", "Cheikh"));
		
		Client c1 = clientRepository.save(new Client("Diop", "samba", a1));
		Client c2 = clientRepository.save(new Client("niang", "aliou", a2));
		Client c3 = clientRepository.save(new Client("sarr", "ami", a3));
		Client c4 = clientRepository.save(new Client("seck", "cherif", a4));
		
		
		Compte cmp1 = compteRepository.save(new CompteCourant(new Date(), 13000.0, c1, 3000.0));
		Compte cmp2 = compteRepository.save(new CompteEpargne(new Date(), 9000.0, c3, 4000.0));
		Compte cmp3 = compteRepository.save(new CompteCourant(new Date(), 5000.0, c2, 2000.0));
		Compte cmp4 = compteRepository.save(new CompteEpargne(new Date(), 8000.0, c4, 3000.0));
		Compte cmp5 = compteRepository.save(new CompteCSansDecouv(new Date(), 8000.0, c4));
		
		operationRepository.save(new Verser(2000.0, new Date(), cmp1));
		operationRepository.save(new Verser(7000.0, new Date(), cmp2));
		operationRepository.save(new Retirer(1500.0, new Date(), cmp4));
		
		Guest g1=guestRepository.save(new Guest());
		Guest g2=guestRepository.save(new Guest());
		Guest g3=guestRepository.save(new Guest());
		
		
		demandeRepository.save(new DemandeCompte("Guisse", "Amary", 265377289L, "amaray@gmail.com",g1));
		demandeRepository.save(new DemandeCompte("Sall", "Aliou", 265377289L, "aliou@gmail.com", g2));
		demandeRepository.save(new DemandeCompte("Thiam", "Samba", 265377289L, "samba@gmail.com", g3));
	*/
	}
	
}
