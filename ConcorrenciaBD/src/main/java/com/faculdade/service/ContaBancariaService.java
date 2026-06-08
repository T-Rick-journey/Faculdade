package com.faculdade.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faculdade.entidade.ContaBancaria;
import com.faculdade.repository.ContaBancariaRepository;

@Service
public class ContaBancariaService {
    
    @Autowired
    ContaBancariaRepository repository;

    public ContaBancaria buscarPorNumeroConta(String numeroConta) {
        return repository.findByNumeroConta(numeroConta);
    }

    public ContaBancaria depositar(String numeroConta, BigDecimal valor) {
        ContaBancaria conta = repository.findByNumeroConta(numeroConta);
        if (conta == null)
            throw new RuntimeException("Conta não encontrada");

        conta.setSaldo(conta.getSaldo().add((valor)));
        return repository.save(conta);
    }

    public ContaBancaria sacar(String numeroConta, BigDecimal valor) {
        ContaBancaria conta = repository.findByNumeroConta(numeroConta);
        if (conta == null)
            throw new RuntimeException("Conta não encontrada");

        if (conta.getSaldo().compareTo(valor) < 0)
            throw new RuntimeException("Saldo insuficiente");

        conta.setSaldo(conta.getSaldo().subtract((valor)));
        return repository.save(conta);
    }

}
