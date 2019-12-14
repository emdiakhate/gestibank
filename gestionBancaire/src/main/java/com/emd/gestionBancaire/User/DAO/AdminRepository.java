package com.emd.gestionBancaire.User.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.emd.gestionBancaire.User.Entities.Admin;

@RepositoryRestResource
public interface AdminRepository extends JpaRepository<Admin, Long> {

}
