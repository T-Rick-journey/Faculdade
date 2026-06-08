package com.faculdade.ConcorrenciaBD.service;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faculdade.ConcorrenciaBD.entidade.ContaBancariaVersionada;
import com.faculdade.ConcorrenciaBD.repository.ContaBancariaVersionadaRepository;

@Service
public class ContaVersionadaService {
    
    private static final Logger logger = LoggerFactory.getLogger(ContaVersionadaService.class);

    @Autowired
    ContaBancariaVersionadaRepository repository;

    private Integer saques = 0;
    private Integer depositos = 0;

    public ContaBancariaVersionada buscarPorNumeroConta(String numeroConta) {
        return repository.findByNumeroConta(numeroConta);
    }

    public ContaBancariaVersionada depositar(String numeroConta, BigDecimal valor) {
        ContaBancariaVersionada conta = repository.findByNumeroConta(numeroConta);
        if (conta == null)
            throw new RuntimeException("Conta não encontrada");
        BigDecimal saldoAntigo = conta.getSaldo();
        conta.setSaldo(conta.getSaldo().add((valor)));
        depositos++;
        logger.info("Depósito " + depositos + ": " + saldoAntigo + " -> " + conta.getSaldo());
        return repository.save(conta);
    }

    public ContaBancariaVersionada sacar(String numeroConta, BigDecimal valor) {
        ContaBancariaVersionada conta = repository.findByNumeroConta(numeroConta);
        if (conta == null)
            throw new RuntimeException("Conta não encontrada");

        if (conta.getSaldo().compareTo(valor) < 0)
            throw new RuntimeException("Saldo insuficiente");

        BigDecimal saldoAntigo = conta.getSaldo();
        conta.setSaldo(conta.getSaldo().subtract((valor)));
        saques++;
        logger.info("Saque " + saques + ": " + saldoAntigo + " -> " + conta.getSaldo());
        return repository.save(conta);
    }
}
