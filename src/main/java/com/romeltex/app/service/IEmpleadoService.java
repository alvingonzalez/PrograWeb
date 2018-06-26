package com.romeltex.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import com.romeltex.app.models.entity.Empleado;
import com.romeltex.app.models.entity.TipoEmpleado;

public interface IEmpleadoService extends CRUD<Empleado>{

	public Page<Empleado> findAll(Pageable pageable);
	public TipoEmpleado findByTipoEmpleado(String tipoempleado);
	
	public List<TipoEmpleado>tiposempleados();
}
