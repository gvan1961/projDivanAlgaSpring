package com.hotel.divan.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.hotel.divan.domain.exception.EntidadeEmUsoException;
import com.hotel.divan.domain.exception.EntidadeNaoEncontradaException;
import com.hotel.divan.domain.model.Apto;
import com.hotel.divan.domain.repository.AptoRepository;


@Service
public class CadastroAptoService {
	
	@Autowired
	private AptoRepository aptoRepository;
	
	public Apto salvar(Apto apto) {
		return aptoRepository.salvar(apto);
	}
	
	public void excluir(Long aptoId) {
		try {
			aptoRepository.remover(aptoId);
			
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de apto com código %d", aptoId));
		
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
				String.format("Apto de código %d não pode ser removido, pois está em uso", aptoId));
		}
	}

}

