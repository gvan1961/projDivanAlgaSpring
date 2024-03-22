package com.hotel.divan.api.controller;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ReflectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.divan.domain.exception.EntidadeEmUsoException;
import com.hotel.divan.domain.exception.EntidadeNaoEncontradaException;
import com.hotel.divan.domain.model.Apto;
import com.hotel.divan.domain.repository.AptoRepository;
import com.hotel.divan.domain.service.CadastroAptoService;


@RestController
@RequestMapping("/aptos")
public class AptoController {
	
	@Autowired
	private AptoRepository aptoRepository;
	
	@Autowired
	private CadastroAptoService cadastroApto;

	@GetMapping
	public List<Apto> listar() {
		return aptoRepository.listar();
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@GetMapping("/{aptoId}")
	public ResponseEntity<Apto> buscar(@PathVariable("aptoId") Long id) {
		Apto apto = aptoRepository.buscar(id);
		
		if (apto != null) {
			return ResponseEntity.ok(apto);
		}
		
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		return ResponseEntity.notFound().build();
	}	
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Apto adicionar(@RequestBody Apto apto) {
		return cadastroApto.salvar(apto);
	}
	
	@PutMapping("/{aptoId}")
	public ResponseEntity<Apto> atualizar(@PathVariable Long aptoId,
			@RequestBody Apto apto) {
		Apto aptoAtual = aptoRepository.buscar(aptoId);
		
		if (aptoAtual != null) {
//			cozinhaAtual.setNome(cozinha.getNome());
			BeanUtils.copyProperties(apto, aptoAtual, "id");
			
			aptoAtual = aptoRepository.salvar(aptoAtual);
			return ResponseEntity.ok(aptoAtual);
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{aptoId}")
	public ResponseEntity<Apto> remover(@PathVariable Long aptoId) {
		try {
			cadastroApto.excluir(aptoId);	
			return ResponseEntity.noContent().build();
			
		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
			
		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
	@PatchMapping("/{aptoId}")
	public ResponseEntity<?> atualizarParcial(@PathVariable Long aptoId,
			@RequestBody Map<String, Object> campos) {
		Apto aptoAtual = aptoRepository.buscar(aptoId);
		
		if (aptoAtual == null) {
			return ResponseEntity.notFound().build();
		}
		merge(campos, aptoAtual); 
		
		return atualizar(aptoId, aptoAtual);
	}

	private void merge(Map<String, Object> dadosOrigem, Apto aptoDestino) {
		ObjectMapper objectMapper = new ObjectMapper();
		Apto aptoOrigem = objectMapper.convertValue(dadosOrigem, Apto.class);
		
		dadosOrigem.forEach((nomePropriedade, valorPropriedade) -> {
			Field field = ReflectionUtils.findField(Apto.class, nomePropriedade);
			field.setAccessible(true);
			
			Object novoValor = ReflectionUtils.getField(field, aptoOrigem);
			
//			System.out.println(nomePropriedade + " = " + valorPropriedade + " = " + novoValor);
			
			ReflectionUtils.setField(field, aptoDestino, novoValor);
		});
	}
}
