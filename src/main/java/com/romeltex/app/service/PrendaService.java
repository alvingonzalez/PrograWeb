package com.romeltex.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.romeltex.app.models.dao.PrendaRepository;
import com.romeltex.app.models.entity.Prenda;
@Service
public class PrendaService implements IPrendaService {

	@Autowired
	private PrendaRepository prendarepossitory;
	
	@Override
	@Transactional(readOnly = true)
	public List<Prenda> findAll() {
		// TODO Auto-generated method stub
		return (List<Prenda>)prendarepossitory.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Prenda findById(Long id) {
		// TODO Auto-generated method stub
		return prendarepossitory.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		prendarepossitory.deleteById(id);
	}

	@Override
	@Transactional
	public void save(Prenda obj) {
		// TODO Auto-generated method stub
		prendarepossitory.save(obj);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Prenda> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return prendarepossitory.findAll(pageable);
	}

}
