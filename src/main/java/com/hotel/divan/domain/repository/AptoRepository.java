package com.hotel.divan.domain.repository;

import java.util.List;

import com.hotel.divan.domain.model.Apto;

public interface AptoRepository {
    
	List<Apto> listar();
	Apto buscar(Long id);
	Apto salvar(Apto apto);
	Apto alterar(Apto apto);
	void remover(Long id);
	
}
