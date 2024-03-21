package com.hotel.divan.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.hotel.divan.domain.model.Apto;
import com.hotel.divan.domain.repository.AptoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class AptoRepositoryImpl implements AptoRepository {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Apto> listar() {
		return manager.createQuery("from Apto", Apto.class)
				.getResultList();
	}

	@Override
	public Apto buscar(Long id) {
		return manager.find(Apto.class, id);
	}

	@Transactional
	@Override
	public Apto salvar(Apto apto) {
		return manager.merge(apto);
	}

	@Override
	public Apto alterar(Apto apto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void remover(Long id) {
	  Apto apto = buscar(id);
	  
	    if(apto == null) {
	    	throw new EmptyResultDataAccessException(1);
	    }
	  
		manager.remove(apto);
		
	}

}
