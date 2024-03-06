package com.hotel.divan.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hotel.divan.domain.model.CategoriaProduto;
import com.hotel.divan.domain.repository.CategoriaProdutoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class CategoriaProdutoRepositoryImpl implements CategoriaProdutoRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<CategoriaProduto> listar() {
		return manager.createQuery("from CategoriaProduto", CategoriaProduto.class)
				.getResultList();
	}

	@Override
	public CategoriaProduto buscar(Long id) {
		return manager.find(CategoriaProduto.class, id);
	}

	@Transactional
	@Override
	public CategoriaProduto salvar(CategoriaProduto categoriaProduto) {
		return manager.merge(categoriaProduto);
	}

	@Override
	public CategoriaProduto alterar(CategoriaProduto categoriaProduto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(CategoriaProduto categoriaProduto) {
		categoriaProduto = buscar(categoriaProduto.getId());
		manager.remove(categoriaProduto);
		
	}

}
