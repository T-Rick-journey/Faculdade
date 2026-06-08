package com.faculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faculdade.entidade.ContaBancaria;

@Repository
public interface ContaBancariaRepository extends JpaRepository<ContaBancaria, Long>{

    @Query("SELECT c FROM ContaBancaria c WHERE c.numeroConta LIKE concat('%', :numeroConta, '%')")
    ContaBancaria findByNumeroConta(String numeroConta);
    
}
