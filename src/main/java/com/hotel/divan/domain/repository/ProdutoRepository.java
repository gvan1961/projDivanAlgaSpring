package com.hotel.divan.domain.repository;

import java.util.List;

import com.hotel.divan.domain.model.Produto;

public interface ProdutoRepository {
	
	List<Produto> listar();
	Produto buscar(Long id);
	Produto salvar(Produto produto);
	Produto alterar(Produto produto);
	void remover(Produto produto);

}
