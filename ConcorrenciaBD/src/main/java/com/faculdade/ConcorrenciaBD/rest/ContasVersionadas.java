package com.faculdade.ConcorrenciaBD.rest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.faculdade.ConcorrenciaBD.entidade.ContaBancariaVersionada;
import com.faculdade.ConcorrenciaBD.service.ContaVersionadaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/contas-versionadas")
@Tag(name = "Contas Bancárias Versionadas", description = "API para gerenciar contas bancárias com controle de versão")
public class ContasVersionadas {
    
    @Autowired
    private ContaVersionadaService service;

    @GetMapping("/test")
    @Operation(summary = "Verificar status", description = "Testa se a API de versionamento está funcionando")
    @ApiResponse(responseCode = "200", description = "API funcionando")
    public ResponseEntity<String> getMethodName() {
        return ResponseEntity.ok("endpoint funcionando com sucesso");
    }

    @GetMapping("/{numeroConta}")
    @Operation(summary = "Buscar conta versionada por número", description = "Busca uma conta bancária versionada pelo número da conta")
    @ApiResponse(responseCode = "200", description = "Conta encontrada")
    @ApiResponse(responseCode = "404", description = "Conta não encontrada")
    public ResponseEntity<ContaBancariaVersionada> buscarPorConta(@PathVariable String numeroConta) {
        ContaBancariaVersionada conta = service.buscarPorNumeroConta(numeroConta);
        if (conta == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(conta);
    }

    @PostMapping("/{numeroConta}/deposito")
    @Operation(summary = "Realizar depósito em conta versionada", description = "Deposita um valor em uma conta bancária versionada")
    @ApiResponse(responseCode = "200", description = "Depósito realizado")
    public ResponseEntity<ContaBancariaVersionada> depositarSemVersao(@PathVariable String numeroConta,
                                                            @RequestParam BigDecimal valor) {
        return ResponseEntity.status(HttpStatus.OK).body(service.depositar(numeroConta, valor));
    }
    
    @PostMapping("/{numeroConta}/sacar")
    @Operation(summary = "Realizar saque em conta versionada", description = "Saca um valor de uma conta bancária versionada")
    @ApiResponse(responseCode = "200", description = "Saque realizado")
    public ResponseEntity<ContaBancariaVersionada> sacarSemVersao(@PathVariable String numeroConta,
                                                        @RequestParam BigDecimal valor) {
        return ResponseEntity.status(HttpStatus.OK).body(service.sacar(numeroConta, valor));
    }
}
