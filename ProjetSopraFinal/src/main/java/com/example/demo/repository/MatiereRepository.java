package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Matiere;

public interface MatiereRepository extends JpaRepository<Matiere, Long> {

	public Optional<Matiere> findByTitre(@Param("titre") String titre);

	public Optional<Matiere> findByDureeProg(@Param("dureeProg") Integer dureeProg);

	public Optional<Matiere> findByObjectif(@Param("objectif") String objectif);

	public Optional<Matiere> findByPrerequis(@Param("prerequis") String prerequis);

	public Optional<Matiere> findByContenu(@Param("contenu") String contenu);
}
