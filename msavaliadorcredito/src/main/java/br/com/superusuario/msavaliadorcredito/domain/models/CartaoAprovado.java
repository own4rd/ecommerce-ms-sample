package br.com.superusuario.msavaliadorcredito.domain.models;


import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoAprovado {
    private String cartao;
    private String bandeira;
    private BigDecimal limiteAprovado;
}
