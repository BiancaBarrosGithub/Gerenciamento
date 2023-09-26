package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Tarefa;
import com.projetojpa.repository.TarefaRepository;



@Service
public class TarefaService {
	private final TarefaRepository tarefaRepository;

	@Autowired
	public TarefaService(TarefaRepository tarefaRepository) {
		this.tarefaRepository = tarefaRepository;
	}
	//Método para buscar todos os produtos
	public List<Tarefa> buscaTodosTarefa() {
		return tarefaRepository.findAll();
	}
	//Método para buscar todos os produtos
		public Tarefa buscaTarefaId(Long id) {
			Optional <Tarefa> tarefa = tarefaRepository.findById(id);
			return tarefa.orElse(null);
		}
		//Método para salvar os produtos
		public Tarefa salvaTarefa(Tarefa tarefa) {
			return tarefaRepository.save(tarefa);
		}
		public Tarefa alterarTarefa(Long id, Tarefa alterarTaref) {
			Optional <Tarefa> existeTarefa = tarefaRepository.findById(id);
			if (existeTarefa.isPresent()) {
				alterarTaref.setId(id);
				return tarefaRepository.save(alterarTaref);
			}
			return null;
		}
		//Método para excluir dados
		public boolean apagarTarefa(Long id) {
			Optional <Tarefa> existeTarefa = tarefaRepository.findById(id);
			if (existeTarefa.isPresent()) {
				tarefaRepository.deleteById(id);
				return true;
			}
			return false;
		}

}
