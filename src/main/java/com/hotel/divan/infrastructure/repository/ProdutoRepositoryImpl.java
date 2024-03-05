package com.hotel.divan.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hotel.divan.domain.model.Produto;
import com.hotel.divan.domain.repository.ProdutoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class ProdutoRepositoryImpl implements ProdutoRepository {
	
	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public List<Produto> listar() {
		return manager.createQuery("from Produto", Produto.class)
				.getResultList();
	}

	@Override
	public Produto buscar(Long id) {
		return manager.find(Produto.class, id);
	}

	@Transactional
	@Override
	public Produto salvar(Produto produto) {
		return manager.merge(produto);
	}

	@Override
	public Produto alterar(Produto produto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remover(Produto produto) {
		produto = buscar(produto.getId());
		manager.remove(produto);
		
	}

}
