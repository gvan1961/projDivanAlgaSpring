package com.hotel.divan.domain.repository;

import java.util.List;

import com.hotel.divan.domain.model.Cliente;

public interface ClienteRepository {
	
	List<Cliente> listar();
	Cliente buscar(Long id);
	Cliente salvar(Cliente cliente);
	Cliente alterar(Cliente cliente);
	void remover(Cliente cliente);

}
