package br.com.superusuario.msavaliadorcredito.domain.exceptions;

public class DadosClientesNotFoundException extends Exception{
    public DadosClientesNotFoundException(){
        super("Dados do cliente não encontrados para o CPF informado.");
    }

}
