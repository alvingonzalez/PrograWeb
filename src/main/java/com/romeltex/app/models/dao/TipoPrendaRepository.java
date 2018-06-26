package com.romeltex.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.romeltex.app.models.entity.TipoPrenda;

@Repository
public interface TipoPrendaRepository extends JpaRepository<TipoPrenda, Long>{

}
