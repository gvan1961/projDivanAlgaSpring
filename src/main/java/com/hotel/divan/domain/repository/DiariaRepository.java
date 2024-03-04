package com.hotel.divan.domain.repository;

import java.util.List;

import com.hotel.divan.domain.model.Diaria;

public interface DiariaRepository {
	
	List<Diaria> listar();
	Diaria buscar(Long id);
	Diaria salvar(Diaria diaria);
	Diaria alterar(Diaria diaria);
	void remover(Diaria diaria);

}
