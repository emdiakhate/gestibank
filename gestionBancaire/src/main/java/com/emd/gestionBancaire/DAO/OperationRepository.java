package com.emd.gestionBancaire.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.emd.gestionBancaire.entities.Operation;

@RepositoryRestResource
public interface OperationRepository extends JpaRepository<Operation, Long>{
	
	@Query("select o from Operation o where o.compte.numeroCompte = x order by o.date_operation desc ")
	public Page<Operation> listOperation(@Param("x")Long idCompte, Pageable page);

}
