package com.hotel.divan.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome",length = 40, nullable = false)
	private String nome;
	
	@Column
	private Integer quantidade;
	
	@Column
	private BigDecimal precoCompra;
	
	@Column(nullable = false)
	private BigDecimal precoVenda;
	
	@ManyToOne
	@JoinColumn(name = "categoria_produto_id", nullable = false)
	private CategoriaProduto categoriaProduto;

}
