package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {

	public Matiere findByTitre(@Param("titre") String titre);

	public Matiere findByDureeProg(@Param("dureeProg") Integer dureeProg);

	public Matiere findByObjectif(@Param("objectif") String objectif);

	public Matiere findByPrerequis(@Param("prerequis") String prerequis);

	public Matiere findByContenu(@Param("contenu") String contenu);
}
