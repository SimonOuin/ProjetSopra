package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Competence;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {

	public Competence findByNiveau(@Param("niveau") String niveau);

}
