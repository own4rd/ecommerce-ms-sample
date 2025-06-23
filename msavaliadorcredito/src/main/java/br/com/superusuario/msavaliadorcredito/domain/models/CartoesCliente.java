package br.com.superusuario.msavaliadorcredito.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartoesCliente {

    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;
}
