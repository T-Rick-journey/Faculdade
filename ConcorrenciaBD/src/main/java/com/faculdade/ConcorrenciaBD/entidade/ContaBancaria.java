package com.faculdade.ConcorrenciaBD.entidade;

import java.math.BigDecimal;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contas_bancarias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContaBancaria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da conta")
    private Long id;

    @Column(name = "numero_conta")
    @Schema(description = "Número da conta bancária")
    private String numeroConta;

    @Column(name = "saldo")
    @Schema(description = "Saldo da conta")
    private BigDecimal saldo;

    @Column(name = "titular")
    @Schema(description = "Titular da conta")
    private String titular;
}
