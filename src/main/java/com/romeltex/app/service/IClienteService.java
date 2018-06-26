package com.romeltex.app.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.romeltex.app.models.entity.Cliente;

public interface IClienteService extends CRUD<Cliente> {
	public Page<Cliente> findAll(Pageable pageable);
}
