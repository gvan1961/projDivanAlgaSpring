package com.hotel.divan.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hotel.divan.domain.exception.EntidadeEmUsoException;
import com.hotel.divan.domain.exception.EntidadeNaoEncontradaException;
import com.hotel.divan.domain.model.TipoApto;
import com.hotel.divan.domain.repository.TipoAptoRepository;

@Service
public class CadastroTipoAptoService {
	
	@Autowired
	private TipoAptoRepository tipoAptoRepository;
	
	public TipoApto salvar(TipoApto tipoApto) {
		return tipoAptoRepository.salvar(tipoApto);
	}
	
	public void excluir(Long tipoAptoId) {
		try {
			tipoAptoRepository.remover(tipoAptoId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de tipo de apto com código %d", tipoAptoId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Tipo de Apto de código %d não pode ser removido, pois está em uso", tipoAptoId));
		}
	}

}
