package com.emd.gestionBancaire.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.emd.gestionBancaire.entities.Compte;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long>{

	

}
