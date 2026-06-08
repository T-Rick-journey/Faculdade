package com.faculdade.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.faculdade.entidade.ContaBancaria;
import com.faculdade.service.ContaBancariaService;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@RestController
@RequestMapping("/contas")
public class Contas {

    
    @Autowired
    private ContaBancariaService service;

    @GetMapping("/test")
    public ResponseEntity<String> getMethodName() {
        return ResponseEntity.ok("endpoint funcionando com sucesso");
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContaBancaria> buscarPorConta(@RequestParam String numeroConta) {
        ContaBancaria conta = service.buscarPorNumeroConta(numeroConta);
        if (conta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conta);
    }

    @PostMapping("/{id}/deposito")
    public ResponseEntity<ContaBancaria> depositarSemVersao(@RequestParam String numeroConta,
                                                            @RequestParam BigDecimal valor) {
        return ResponseEntity.status(HttpStatus.OK).body(service.depositar(numeroConta, valor));
    }
    
    @PostMapping("/{id}/sacar")
    public ResponseEntity<ContaBancaria> sacarSemVersao(@RequestParam String numeroConta,
                                                        @RequestParam BigDecimal valor) {
        return ResponseEntity.status(HttpStatus.OK).body(service.sacar(numeroConta, valor));
    }

}
