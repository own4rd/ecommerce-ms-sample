package br.com.superusuario.mscartoes.application.resource;

import br.com.superusuario.mscartoes.application.dto.CartaoSaveRequestDto;
import br.com.superusuario.mscartoes.application.dto.CartoesPorClienteResponseDto;
import br.com.superusuario.mscartoes.application.service.CartaoService;
import br.com.superusuario.mscartoes.application.service.ClienteCartaoService;
import br.com.superusuario.mscartoes.domain.Cartao;
import br.com.superusuario.mscartoes.domain.ClienteCartao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cartoes")
@RequiredArgsConstructor
public class CartaoResource {

    private final CartaoService cartaoService;
    private final ClienteCartaoService clienteCartaoService;

    @GetMapping
    public String status(){
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastra( @RequestBody CartaoSaveRequestDto request ){
        Cartao cartao = request.toModel();
        cartaoService.save(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<Cartao>> getCartoesRendaAteh(@RequestParam("renda") Long renda){
        List<Cartao> list = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok(list);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CartoesPorClienteResponseDto>> getCartoesByCliente(
            @RequestParam("cpf") String cpf){
        List<ClienteCartao> lista = clienteCartaoService.listCartoesByCpf(cpf);
        List<CartoesPorClienteResponseDto> resultList = lista.stream()
                .map(CartoesPorClienteResponseDto::fromModel)
                .collect(Collectors.toList());
        return ResponseEntity.ok(resultList);
    }
}
