package com.romeltex.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.romeltex.app.models.dao.SucursalRepository;
import com.romeltex.app.models.entity.Sucursal;

@Service
public class SucursalService implements ISucursalService {

	@Autowired
	private SucursalRepository sucursalrepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Sucursal> findAll() {
		// TODO Auto-generated method stub
		return (List<Sucursal>)sucursalrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Sucursal findById(Long id) {
		// TODO Auto-generated method stub
		return sucursalrepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		sucursalrepository.deleteById(id);
	}

	@Override
	@Transactional
	public void save(Sucursal obj) {
		// TODO Auto-generated method stub
		sucursalrepository.save(obj);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Sucursal> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return sucursalrepository.findAll(pageable);
	}

}
