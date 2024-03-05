package com.hotel.divan.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hotel.divan.domain.model.Cliente;
import com.hotel.divan.domain.repository.ClienteRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class ClienteRepositoryImpl  implements ClienteRepository {
    
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Cliente> listar() {
		return manager.createQuery("from Cliente", Cliente.class)
				.getResultList();
	}

	@Override
	public Cliente buscar(Long id) {
		return manager.find(Cliente.class, id);
	}

	@Transactional
	@Override
	public Cliente salvar(Cliente cliente) {
		return manager.merge(cliente);
	}

	@Override
	public Cliente alterar(Cliente liente) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Cliente cliente) {
		cliente = buscar(cliente.getId());
		manager.remove(cliente);
		
	}

}
