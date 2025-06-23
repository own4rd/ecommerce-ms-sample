package br.com.superusuario.msavaliadorcredito.domain.exceptions;

public class ErroSolicitacaoCartaoException extends RuntimeException{

    public ErroSolicitacaoCartaoException(String message){
        super(message);
    }
}
