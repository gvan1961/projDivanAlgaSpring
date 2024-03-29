package com.hotel.divan.infrastructure.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import com.hotel.divan.domain.model.TipoApto;
import com.hotel.divan.domain.repository.TipoAptoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class TipoAptoRepositoryImpl implements TipoAptoRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<TipoApto> listar() {
		return manager.createQuery("from TipoApto", TipoApto.class)
				.getResultList();
	}

	@Override
	public TipoApto buscar(Long id) {
		return manager.find(TipoApto.class, id);
	}

	@Transactional
	@Override
	public TipoApto salvar(TipoApto tipoApto) {
		return manager.merge(tipoApto);
	}

	@Transactional
	@Override
	public TipoApto alterar(TipoApto tipoApto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public void remover(Long id) {
	  TipoApto tipoApto = buscar(id);
	  
	    if(tipoApto == null) {
	    	throw new EmptyResultDataAccessException(1);
	    }
	  
		manager.remove(tipoApto);
		
	}

}
