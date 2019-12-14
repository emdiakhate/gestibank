package com.emd.gestionBancaire.Compte.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.emd.gestionBancaire.Compte.Entities.Compte;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, Long>{

	

}
