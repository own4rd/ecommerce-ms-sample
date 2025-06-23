package br.com.superusuario.msavaliadorcredito.infra.controller;

import br.com.superusuario.msavaliadorcredito.domain.exceptions.DadosClientesNotFoundException;
import br.com.superusuario.msavaliadorcredito.domain.exceptions.ErroComunicacaoMicroservicesException;
import br.com.superusuario.msavaliadorcredito.domain.exceptions.ErroSolicitacaoCartaoException;
import br.com.superusuario.msavaliadorcredito.domain.models.*;
import br.com.superusuario.msavaliadorcredito.infra.service.AvaliadorCreditoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("avaliacoes-credito")
public class AvaliadorCreditoController {

    private final AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping(value = "situacaoCliente", params = "cpf")
    public ResponseEntity consultaSituacaoCliente(@RequestParam("cpf") String cpf){
        try {
            SituacaoCliente situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
            return ResponseEntity.ok(situacaoCliente);

        } catch (DadosClientesNotFoundException e){
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroservicesException e){
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity realizarAvaliacao(@RequestBody DadosAvaliacao dados){
        try {
            RetornoAvaliacaoCliente retornoAvaliacaoCliente = avaliadorCreditoService.realizarAvaliacao(dados.getCpf(), dados.getRenda());
            return ResponseEntity.ok(retornoAvaliacaoCliente);

        } catch (DadosClientesNotFoundException e){
            return ResponseEntity.notFound().build();
        } catch (ErroComunicacaoMicroservicesException e){
            return ResponseEntity.status(HttpStatus.resolve(e.getStatus())).body(e.getMessage());
        }
    }

    @PostMapping("solicitacoes-cartao")
    public ResponseEntity solicitarCartao(@RequestBody DadosSolicitacaoEmissaoCartao dados){
        try {
            ProtocoloSolicitacaoCartao protoloco = avaliadorCreditoService.SolicitarEmissaoCartao(dados);
            return ResponseEntity.ok(protoloco);
        } catch (ErroSolicitacaoCartaoException e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
