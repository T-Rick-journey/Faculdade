package com.faculdade.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.faculdade.entidade.ContaBancaria;
import com.faculdade.service.ContaBancariaService;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;



@RestController
@RequestMapping("/contas")
@Tag(name = "Contas Bancárias", description = "API para gerenciar contas bancárias")
public class Contas {

    @Autowired
    private ContaBancariaService service;

    @GetMapping("/test")
    @Operation(summary = "Verificar status", description = "Testa se a API está funcionando")
    @ApiResponse(responseCode = "200", description = "API funcionando")
    public ResponseEntity<String> getMethodName() {
        return ResponseEntity.ok("endpoint funcionando com sucesso");
    }

    @GetMapping("/{numeroConta}")
    @Operation(summary = "Buscar conta por número", description = "Busca uma conta bancária pelo número da conta")
    @ApiResponse(responseCode = "200", description = "Conta encontrada")
    @ApiResponse(responseCode = "404", description = "Conta não encontrada")
    public ResponseEntity<ContaBancaria> buscarPorConta(@PathVariable String numeroConta) {
        ContaBancaria conta = service.buscarPorNumeroConta(numeroConta);
        if (conta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conta);
    }

    @PostMapping("/{numeroConta}/deposito")
    @Operation(summary = "Realizar depósito", description = "Deposita um valor em uma conta bancária")
    @ApiResponse(responseCode = "200", description = "Depósito realizado")
    public ResponseEntity<ContaBancaria> depositarSemVersao(@PathVariable String numeroConta,
                                                            @RequestParam BigDecimal valor) {
        return ResponseEntity.status(HttpStatus.OK).body(service.depositar(numeroConta, valor));
    }
    
    @PostMapping("/{numeroConta}/sacar")
    @Operation(summary = "Realizar saque", description = "Saca um valor de uma conta bancária")
    @ApiResponse(responseCode = "200", description = "Saque realizado")
    public ResponseEntity<ContaBancaria> sacarSemVersao(@PathVariable String numeroConta,
                                                        @RequestParam BigDecimal valor) {
        return ResponseEntity.status(HttpStatus.OK).body(service.sacar(numeroConta, valor));
    }

}
