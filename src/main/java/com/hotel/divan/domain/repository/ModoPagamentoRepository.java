package com.hotel.divan.domain.repository;

import java.util.List;

import com.hotel.divan.domain.model.ModoPagamento;

public interface ModoPagamentoRepository {
	
	List<ModoPagamento> listar();
	ModoPagamento buscar(Long id);
	ModoPagamento salvar(ModoPagamento modoPagamento);
	ModoPagamento alterar(ModoPagamento modoPagamento);
	void remover(ModoPagamento modoPagamento);

}
