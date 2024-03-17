package com.hotel.divan.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.divan.domain.model.TipoApto;
import com.hotel.divan.domain.repository.TipoAptoRepository;


@RestController
@RequestMapping("/tipoAptos")
public class TipoAptoController {
	
	//private static final HttpStatus value =  = null;
	@Autowired
	private TipoAptoRepository tipoAptoRepository;

	@GetMapping
	public List<TipoApto> listar() {
		return tipoAptoRepository.listar();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/{tipoAptoId}")
	public ResponseEntity<TipoApto> buscar(@PathVariable("tipoAptoId") Long id) {
		TipoApto tipoApto = tipoAptoRepository.buscar(id);
		
		if (tipoApto != null) {
			return ResponseEntity.ok(tipoApto);
		}
		
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.notFound().build();
	}	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public TipoApto adicionar(@RequestBody TipoApto tipoApto) {
		return tipoAptoRepository.salvar(tipoApto);
	}
	
	@PutMapping("/{tipoAptoId}")
	public ResponseEntity<TipoApto> atualizar(@PathVariable Long tipoAptoId,
			@RequestBody TipoApto tipoApto) {
		TipoApto tipoAptoAtual = tipoAptoRepository.buscar(tipoAptoId);
		
		if (tipoAptoAtual != null) {
//			cozinhaAtual.setNome(cozinha.getNome());
			BeanUtils.copyProperties(tipoApto, tipoAptoAtual, "id");
			
			tipoAptoAtual = tipoAptoRepository.salvar(tipoAptoAtual);
			return ResponseEntity.ok(tipoAptoAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{tipoAptoId}")
	public ResponseEntity<TipoApto> remover(@PathVariable Long tipoAptoId) {
		try {
			TipoApto tipoApto = tipoAptoRepository.buscar(tipoAptoId);
			
			if (tipoApto != null) {
				tipoAptoRepository.remover(tipoApto);
				
				return ResponseEntity.noContent().build();
			}
			
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
}
