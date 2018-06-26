package com.romeltex.app.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.romeltex.app.models.entity.Sucursal;
@Repository
public interface SucursalRepository extends JpaRepository<Sucursal, Long>{

}
