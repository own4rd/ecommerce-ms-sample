package br.com.superusuario.msavaliadorcredito.infra.clients;

import br.com.superusuario.msavaliadorcredito.domain.models.DadosCliente;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "msclientes",
        url = "${msclientes.url}",
        path = "/clientes"
)
public interface ClienteResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<DadosCliente> dadosCliente (@RequestParam("cpf") String cpf);
}
