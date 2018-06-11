package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Competence;
import com.example.demo.model.CompetencePk;
import com.example.demo.model.Formation;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {

	public Optional<Competence> findByNiveau(@Param("niveau") String niveau);

	public Optional<Competence> findByKey(@Param("key") CompetencePk key);

	public Optional<Competence> deleteByKey(CompetencePk key);

}
