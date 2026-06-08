package com.faculdade.ConcorrenciaBD.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faculdade.ConcorrenciaBD.entidade.ContaBancariaVersionada;
import com.faculdade.ConcorrenciaBD.repository.ContaBancariaVersionadaRepository;

@Service
public class ContaVersionadaService {
    
    @Autowired
    ContaBancariaVersionadaRepository repository;

    public ContaBancariaVersionada buscarPorNumeroConta(String numeroConta) {
        return repository.findByNumeroConta(numeroConta);
    }

    public ContaBancariaVersionada depositar(String numeroConta, BigDecimal valor) {
        ContaBancariaVersionada conta = repository.findByNumeroConta(numeroConta);
        if (conta == null)
            throw new RuntimeException("Conta não encontrada");

        conta.setSaldo(conta.getSaldo().add((valor)));
        return repository.save(conta);
    }

    public ContaBancariaVersionada sacar(String numeroConta, BigDecimal valor) {
        ContaBancariaVersionada conta = repository.findByNumeroConta(numeroConta);
        if (conta == null)
            throw new RuntimeException("Conta não encontrada");

        if (conta.getSaldo().compareTo(valor) < 0)
            throw new RuntimeException("Saldo insuficiente");

        conta.setSaldo(conta.getSaldo().subtract((valor)));
        return repository.save(conta);
    }
}
