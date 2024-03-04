package com.hotel.divan.domain.repository;

import java.util.List;

import com.hotel.divan.domain.model.TipoApto;

public interface TipoAptoRepository {
	
	List<TipoApto> listar();
	TipoApto buscar(Long id);
	TipoApto salvar(TipoApto tipoApto);
	TipoApto alterar(TipoApto tipoApto);
	void remover(TipoApto tipoApto);

}
