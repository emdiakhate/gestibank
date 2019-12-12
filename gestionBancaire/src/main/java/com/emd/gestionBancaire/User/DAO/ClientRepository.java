package com.emd.gestionBancaire.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.emd.gestionBancaire.entities.Client;

@RepositoryRestResource
@CrossOrigin("*")
public interface ClientRepository extends JpaRepository<Client, Long> {
	@Query("select c from Client c where c.agent.id_agent = x  ")
	public List<Client> listClient(@Param("x")Long idAgent);	
	
}
