package com.romeltex.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.romeltex.app.models.dao.OrdenRepository;
import com.romeltex.app.models.entity.Orden;
@Service
public class OrdenService implements IOrdenService {

	@Autowired
	private OrdenRepository ordenrepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Orden> findAll() {
		// TODO Auto-generated method stub
		return (List<Orden>)ordenrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Orden findById(Long id) {
		// TODO Auto-generated method stub
		return ordenrepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		ordenrepository.deleteById(id);
	}

	@Override
	public void save(Orden obj) {
		// TODO Auto-generated method stub
		ordenrepository.save(obj);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Orden> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return ordenrepository.findAll(pageable);
	}

}
