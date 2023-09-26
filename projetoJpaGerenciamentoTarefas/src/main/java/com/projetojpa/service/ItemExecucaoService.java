package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.ItemExecucao;
import com.projetojpa.repository.ItemExecucaoRepository;



@Service
public class ItemExecucaoService {

	private final ItemExecucaoRepository itemExecucaoRepository;

	@Autowired
	public ItemExecucaoService(ItemExecucaoRepository itemExecucaoRepository) {
		this.itemExecucaoRepository = itemExecucaoRepository;
	}
	//Método para buscar todos os produtos
	public List<ItemExecucao> buscaTodosItemExecucao() {
		return itemExecucaoRepository.findAll();
	}
	//Método para buscar todos os produtos
		public ItemExecucao buscaTodosItemExecucaoId(Long id) {
			Optional <ItemExecucao> itemExecucao = itemExecucaoRepository.findById(id);
			return itemExecucao.orElse(null);
		}
		//Método para salvar os produtos
		public ItemExecucao salvaItemExecucao(ItemExecucao itemExecucao) {
			return itemExecucaoRepository.save(itemExecucao);
		}
		public ItemExecucao alterarItemExecucao(Long id, ItemExecucao alterarItemEx) {
			Optional <ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(id);
			if (existeItemExecucao.isPresent()) {
				alterarItemEx.setId(id);
				return itemExecucaoRepository.save(alterarItemEx);
			}
			return null;
		}		
		//Método para excluir dados
		public boolean apagarItemExecucao(Long id) {
			Optional <ItemExecucao> existeItemExecucao = itemExecucaoRepository.findById(id);
			if (existeItemExecucao.isPresent()) {
				itemExecucaoRepository.deleteById(id);
				return true;
			}
			return false;
		}
}
