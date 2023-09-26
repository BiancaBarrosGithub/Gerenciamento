package com.projetojpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projetojpa.entities.ItemExecucao;
import com.projetojpa.service.ItemExecucaoService;



@RestController
@RequestMapping("/itemExecucao")
public class ItemExecucaoController {
private final ItemExecucaoService itemExecucaoService;
	
	@Autowired
	public ItemExecucaoController(ItemExecucaoService itemExecucaoService) {
		this.itemExecucaoService = itemExecucaoService;
	}
	@GetMapping("/{id}")
	public ResponseEntity<ItemExecucao> buscaItemExecucaoControlId(@PathVariable Long id){
		ItemExecucao itemExecucao = itemExecucaoService.buscaTodosItemExecucaoId(id);
		if(itemExecucao != null) {
			return ResponseEntity.ok(itemExecucao);
		}
			else {
				return ResponseEntity.notFound().build();
			}
		}
	@GetMapping("/")
	public ResponseEntity<List<ItemExecucao>> buscaTodosItemExecucaoId(){
		List<ItemExecucao> itemExecucao = itemExecucaoService.buscaTodosItemExecucao();
		return ResponseEntity.ok(itemExecucao);
	}
	@PostMapping("/")
	public ResponseEntity<ItemExecucao> salvaItemExecucaoId(@RequestBody ItemExecucao itemExecucao){
		ItemExecucao salvaItemExecucao = itemExecucaoService.salvaItemExecucao(itemExecucao);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvaItemExecucao);
	}
	@PutMapping("/{id}")
	public ResponseEntity<ItemExecucao> alteraItemExecucaoId(@PathVariable Long id, @RequestBody ItemExecucao itemExecucao){
		ItemExecucao alteraItemExecucao = itemExecucaoService.alterarItemExecucao(id, itemExecucao);
		if (alteraItemExecucao != null) {
			return ResponseEntity.ok(itemExecucao);
		}
		else {
			return ResponseEntity.notFound().build();
		}	
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<String> apagaItemExecucaoId(@PathVariable Long id){
		boolean apagar = itemExecucaoService.apagarItemExecucao(id);
		if (apagar) {
			return ResponseEntity.ok().body("O Produto foi excluido com sucesso");
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
