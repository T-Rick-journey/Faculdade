package com.faculdade.ConcorrenciaBD.entidade;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contas_bancarias_versionada")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaBancariaVersionada {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da conta versionada")
    private Long id;

    @Column(name = "numero_conta")
    @Schema(description = "Número da conta bancária versionada")
    private String numeroConta;

    @Column(name = "saldo")
    @Schema(description = "Saldo da conta versionada")
    private BigDecimal saldo;

    @Column(name = "titular")
    @Schema(description = "Titular da conta versionada")
    private String titular;

    @Version
    @Column(name = "versao")
    @Schema(description = "Versão para controle de concorrência")
    private Integer versao;
}
