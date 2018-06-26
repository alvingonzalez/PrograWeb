package com.romeltex.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.romeltex.app.models.dao.ServicioRepository;
import com.romeltex.app.models.entity.Servicio;

@Service
public class ServicioService implements IServicioService {

	@Autowired
	private ServicioRepository serviciorepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Servicio> findAll() {
		// TODO Auto-generated method stub
		return (List<Servicio>)serviciorepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Servicio findById(Long id) {
		// TODO Auto-generated method stub
		return serviciorepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		serviciorepository.deleteById(id);
	}

	@Override
	@Transactional
	public void save(Servicio obj) {
		// TODO Auto-generated method stub
		serviciorepository.save(obj);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Servicio> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return serviciorepository.findAll(pageable);
	}

}
