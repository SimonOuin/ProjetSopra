package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Formateur;
import com.example.demo.model.Matiere;
import com.example.demo.model.Module;
import com.example.demo.model.Salle;

public interface ModuleRepository extends JpaRepository<Module, Long> {

	public Module findBySalle(@Param("salle") Salle salle);

	public Module findByFormateur(@Param("formateur") Formateur formateur);

	public Module findByMatiere(@Param("matiere") Matiere matiere);

	public Module findByDateDebut(@Param("DateDebut") Date DateDebut);
}
