package com.example.demo.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Formation;
import com.example.demo.model.Module;
import com.example.demo.model.Stagiaire;

public interface FormationRepository extends JpaRepository<Formation, Long> {

	public Optional<Formation> findByStagiaires(@Param("stagiaire") Stagiaire stagiaire);

	public Optional<Formation> findByModules(@Param("module") Module module);

	public Optional<Formation> findByDateDebut(@Param("DateDebut") Date DateDebut);

	public Optional<Formation> findByDateFin(@Param("DateFin") Date DateFin);
}
