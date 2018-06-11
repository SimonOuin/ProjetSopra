package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Adresse;
import com.example.demo.model.RessourceHumaine;

public interface RessourceHumaineRepository extends JpaRepository<RessourceHumaine, Long> {

	public Optional<RessourceHumaine> findByNom(@Param("nom") String nom);

	public Optional<RessourceHumaine> findByPrenom(@Param("prenom") String prenom);

	public Optional<RessourceHumaine> findByAdresse(@Param("adresse") Adresse adresse);

	public Optional<RessourceHumaine> findByTel(@Param("tel") Integer tel);

	public Optional<RessourceHumaine> findByEmail(@Param("email") String email);

	public Optional<RessourceHumaine> findByLogin(@Param("login") String login);

	public Optional<RessourceHumaine> findByMdp(@Param("mdp") String mdp);
	
//	@Query("select distinct f from Formateur f left outer join fetch f.stagiaire")
//	public List<RessourceHumaine> findAllFormateurWithStagiaire();
	

}
