package com.hotel.divan.domain.repository;

import java.util.List;

import com.hotel.divan.domain.model.CategoriaProduto;

public interface CategoriaProdutoRepository {
	
	List<CategoriaProduto> listar();
	CategoriaProduto buscar(Long id);
	CategoriaProduto salvar(CategoriaProduto categoriaProduto);
	CategoriaProduto alterar(CategoriaProduto categoriaProduto);
	void remover(CategoriaProduto categoriaProduto);

}
