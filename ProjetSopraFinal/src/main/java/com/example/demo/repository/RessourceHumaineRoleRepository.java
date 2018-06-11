package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.RessourceHumaineRole;

public interface RessourceHumaineRoleRepository extends JpaRepository<RessourceHumaineRole, Integer> {

	@Query("select distinct rhr.role from RessourceHumaineRole rhr where rhr.ressourceHumaine.login=?1")
	List<String> findCustomRoleByLogin(String login);
	
}
