package com.hotel.divan.domain.repository;

import java.util.List;

import com.hotel.divan.domain.model.Permissao;

public interface PermissaoRepository {
	
	List<Permissao> listar();
	Permissao buscar(Long id);
	Permissao salvar(Permissao permissao);
	Permissao alterar(Permissao permissao);
	void remover(Permissao permissao);

}
