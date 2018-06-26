package com.romeltex.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.romeltex.app.models.dao.ClienteRepository;
import com.romeltex.app.models.entity.Cliente;

@Service
public class ClienteService implements IClienteService {

	@Autowired
	private ClienteRepository clienterepository;
	
	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return (List<Cliente>)clienterepository.findAll() ;
	}
	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return clienterepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
		clienterepository.deleteById(id);
		
	}

	@Override
	@Transactional
	public void save(Cliente obj) {
		// TODO Auto-generated method stub
		clienterepository.save(obj);
	}
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return clienterepository.findAll(pageable);
	}

}
