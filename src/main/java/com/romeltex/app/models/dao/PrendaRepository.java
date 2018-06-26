package com.romeltex.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeltex.app.models.entity.Prenda;

@Repository
public interface PrendaRepository extends JpaRepository<Prenda, Long>{

}
