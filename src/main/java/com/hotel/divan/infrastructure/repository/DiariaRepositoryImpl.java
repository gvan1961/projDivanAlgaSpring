package com.hotel.divan.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hotel.divan.domain.model.Diaria;
import com.hotel.divan.domain.repository.DiariaRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class DiariaRepositoryImpl implements DiariaRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Diaria> listar() {
		return manager.createQuery("from Diaria", Diaria.class)
				.getResultList();
	}

	@Override
	public Diaria buscar(Long id) {
		return manager.find(Diaria.class, id);
	}

	@Transactional
	@Override
	public Diaria salvar(Diaria diaria) {
		return manager.merge(diaria);
	}

	@Override
	public Diaria alterar(Diaria diaria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Diaria diaria) {
		diaria = buscar(diaria.getId());
		manager.remove(diaria);
		
	}

}
