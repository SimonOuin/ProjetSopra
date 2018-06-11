package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, Long> {

	public Optional<Materiel> findByCode(@Param("code") Long code);

	public Optional<Materiel> findByCout(@Param("cout") Integer cout);
}
