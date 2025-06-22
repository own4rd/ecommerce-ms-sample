package br.com.superusuario.msclientes.application.dto;

import br.com.superusuario.msclientes.domain.Cliente;
import lombok.Data;

@Data
public class ClienteSaveRequestDto {

    private String cpf;
    private String nome;
    private Integer idade;

    public Cliente toModal(){
        return new Cliente(cpf, nome, idade);
    }
}
