package com.hotel.divan.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hotel.divan.domain.model.ModoPagamento;
import com.hotel.divan.domain.repository.ModoPagamentoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class ModoPagamentoRepositoryImpl implements ModoPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<ModoPagamento> listar() {
		return manager.createQuery("from ModoPagamento", ModoPagamento.class)
				.getResultList();
	}

	@Override
	public ModoPagamento buscar(Long id) {
		return manager.find(ModoPagamento.class, id);
	}

	@Transactional
	@Override
	public ModoPagamento salvar(ModoPagamento modoPagamento) {
		return manager.merge(modoPagamento);
	}

	@Override
	public ModoPagamento alterar(ModoPagamento modoPagamento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(ModoPagamento modoPagamento) {
		modoPagamento = buscar(modoPagamento.getId());
		manager.remove(modoPagamento);
		
	}
}
