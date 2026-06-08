package com.faculdade.entidade;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contas_bancarias_versionada")
@Getter
@Setter
@NoArgsConstructor
public class ContaBancariaVersionada {
        
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_conta")
    private String numeroConta;

    @Column(name = "saldo")
    private BigDecimal saldo;

    @Column(name = "titular")
    private String titular;

    @Version
    @Column(name = "versao")
    private Integer versao;
}
