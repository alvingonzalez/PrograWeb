package com.romeltex.app.models.dao;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.romeltex.app.models.entity.Cliente;

@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>{


	//@Query("Select c from Cliente c join fetch c.")
	//public Cliente fetchByIdWithOrden(Long id);
}
