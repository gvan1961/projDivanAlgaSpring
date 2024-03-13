package com.hotel.divan.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.divan.domain.model.TipoApto;
import com.hotel.divan.domain.repository.TipoAptoRepository;


@RestController
@RequestMapping("/tipoAptos")
public class TipoAptoController {
	
	@Autowired
	private TipoAptoRepository tipoAptoRepository;

	@GetMapping
	public List<TipoApto> listar() {
		return tipoAptoRepository.listar();
	}
}
