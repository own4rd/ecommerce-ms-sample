package br.com.superusuario.mscartoes.application.dto;

import br.com.superusuario.mscartoes.domain.BandeiraCartao;
import br.com.superusuario.mscartoes.domain.Cartao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoSaveRequestDto {

    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public Cartao toModel(){
        return new Cartao(nome, bandeira, renda, limite );
    }
}
