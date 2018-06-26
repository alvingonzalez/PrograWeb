package com.romeltex.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.romeltex.app.models.dao.EmpleadoRepository;
import com.romeltex.app.models.entity.Empleado;
import com.romeltex.app.models.entity.TipoEmpleado;

@Service
public class EmpleadoService implements IEmpleadoService {

	@Autowired
	private EmpleadoRepository empleadorepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		// TODO Auto-generated method stub
		return (List<Empleado>)empleadorepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id) {
		// TODO Auto-generated method stub
		return empleadorepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		empleadorepository.deleteById(id);
	}

	@Override
	@Transactional
	public void save(Empleado obj) {
		// TODO Auto-generated method stub
		empleadorepository.save(obj);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Empleado> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return empleadorepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public TipoEmpleado findByTipoEmpleado(String tipoempleado) {
		// TODO Auto-generated method stub
		return empleadorepository.findByTipoEmpleado(tipoempleado);
	}

	@Override
	public List<TipoEmpleado> tiposempleados() {
		// TODO Auto-generated method stub
		return empleadorepository.tiposempleados();
	}

}
