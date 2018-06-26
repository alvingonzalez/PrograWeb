package com.romeltex.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.romeltex.app.models.dao.TipoPrendaRepository;
import com.romeltex.app.models.entity.TipoPrenda;

@Service
public class TipoPrendaService implements ITipoPrendaService {

	@Autowired
	private TipoPrendaRepository tipoprendarepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<TipoPrenda> findAll() {
		// TODO Auto-generated method stub
		return (List<TipoPrenda>)tipoprendarepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public TipoPrenda findById(Long id) {
		// TODO Auto-generated method stub
		return tipoprendarepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		tipoprendarepository.deleteById(id);
	}

	@Override
	@Transactional
	public void save(TipoPrenda obj) {
		// TODO Auto-generated method stub
		tipoprendarepository.save(obj);
	}

	@Override
	@Transactional(readOnly = true)
	public Page<TipoPrenda> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return tipoprendarepository.findAll(pageable);
	}

}
