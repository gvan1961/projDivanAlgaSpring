package com.hotel.divan.domain.model;

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
@Table(name = "apto")
public class Apto {

	@Id
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	@Column(nullable = false)
	private Integer qtdeCamas;
	@Column
	private String situacao; // ocupado disponivel
	
	@ManyToOne
	@JoinColumn(name = "tipo_apto_id", nullable = false)
	private TipoApto tipoApto;
	
	// ultima locacao
}
