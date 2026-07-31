package br.com.fiap.atendimento.infra.addapter.outbound.controller;

import br.com.fiap.atendimento.application.usecase.inbound.atualizar.Atualizar;
import br.com.fiap.atendimento.application.usecase.inbound.atualizar.AtualizarInput;
import br.com.fiap.atendimento.application.usecase.inbound.atualizar.AtualizarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.buscar.Buscar;
import br.com.fiap.atendimento.application.usecase.inbound.buscar.BuscarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.cancelar.Cancelar;
import br.com.fiap.atendimento.application.usecase.inbound.cancelar.CancelarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.gerar.Gerar;
import br.com.fiap.atendimento.application.usecase.inbound.gerar.GerarInput;
import br.com.fiap.atendimento.application.usecase.inbound.gerar.GerarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.listar.Listar;
import br.com.fiap.atendimento.application.usecase.inbound.listar.ListarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.marcar.Marcar;
import br.com.fiap.atendimento.application.usecase.inbound.marcar.MarcarInput;
import br.com.fiap.atendimento.application.usecase.inbound.marcar.MarcarOutput;
import br.com.fiap.atendimento.infra.addapter.inbound.dto.AtendimentoDTO;
import br.com.fiap.atendimento.infra.addapter.inbound.dto.MarcarDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/atendimento")
public class AtendimentoController {
    private final Listar listar;
    private final Buscar buscar;
    private final Gerar gerar;
    private final Cancelar cancelar;
    private final Atualizar atualizar;
    private final Marcar marcar;

    public AtendimentoController(Listar listar, Buscar buscar, Gerar gerar, Cancelar cancelar, Atualizar atualizar, Marcar marcar) {
        this.listar = listar;
        this.buscar = buscar;
        this.gerar = gerar;
        this.cancelar = cancelar;
        this.atualizar = atualizar;
        this.marcar = marcar;
    }

    @GetMapping("/listar")
    ResponseEntity<List<ListarOutput>> listar () {
        return ResponseEntity.status(HttpStatus.OK).body(listar.listar());
    }

    @GetMapping("/buscar/{id}")
    ResponseEntity<BuscarOutput> buscar (@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(buscar.buscar(id));
    }

    @PostMapping("/gerar")
    ResponseEntity<GerarOutput> gerar (@RequestBody AtendimentoDTO atendimentoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(gerar.gerar(GerarInput.from(AtendimentoDTO.to(atendimentoDTO))));
    }

    @PutMapping("/atualizar")
    ResponseEntity<AtualizarOutput> atualizar (@RequestBody AtendimentoDTO atendimentoDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(atualizar.atualizar(AtualizarInput.from(AtendimentoDTO.to(atendimentoDTO))));
    }

    @DeleteMapping("/cancelar/{id}")
    ResponseEntity<CancelarOutput> cancelar (@PathVariable(value = "id") String id) {
        return ResponseEntity.status(HttpStatus.OK).body(cancelar.cancelar(id));
    }

    @PutMapping("/marcar")
    ResponseEntity<MarcarOutput> marcar (@RequestBody MarcarDTO marcarDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(marcar.marcar(MarcarInput.to(AtendimentoDTO.to(marcarDTO.atendimentoDTO()), marcarDTO.exames())));
    }
}
