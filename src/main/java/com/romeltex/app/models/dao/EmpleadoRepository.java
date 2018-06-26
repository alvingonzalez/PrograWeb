package com.romeltex.app.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.romeltex.app.models.entity.Empleado;
import com.romeltex.app.models.entity.TipoEmpleado;
@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

	@Query("select e from Empleado e left join fetch e.tipoempleado t where e.tipoempleado=?1")
	public TipoEmpleado findByTipoEmpleado(String tipoempleado);
	
	@Query("Select t from TipoEmpleado t")
	public List<TipoEmpleado> tiposempleados();
}
