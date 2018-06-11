package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Materiel;

public interface MaterielRepository extends JpaRepository<Materiel, Long> {

	public Materiel findByCode(@Param("code") Integer code);

	public Materiel findByCout(@Param("cout") Integer cout);
}
