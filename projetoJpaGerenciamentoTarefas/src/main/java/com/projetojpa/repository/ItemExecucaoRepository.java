package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.ItemExecucao;

public interface ItemExecucaoRepository extends JpaRepository<ItemExecucao, Long>{
	// Nenhuma implementação é necessária. Spring Data JPA cuidará disso.

}
