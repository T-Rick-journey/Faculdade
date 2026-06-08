package com.faculdade.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.faculdade.entidade.ContaBancariaVersionada;

@Repository
public interface ContaBancariaVersionadaRepository extends JpaRepository<ContaBancariaVersionada, Long> {
    
    @Query("SELECT c FROM ContaBancariaVersionada c WHERE c.numeroConta LIKE concat('%', :numeroConta, '%')")
    ContaBancariaVersionada findByNumeroConta(String numeroConta);
}
