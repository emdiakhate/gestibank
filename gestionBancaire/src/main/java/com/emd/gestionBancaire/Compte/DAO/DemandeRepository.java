package com.emd.gestionBancaire.Compte.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.emd.gestionBancaire.Compte.Entities.DemandeCompte;

@RepositoryRestResource
public interface DemandeRepository extends JpaRepository<DemandeCompte, Long>{

}
