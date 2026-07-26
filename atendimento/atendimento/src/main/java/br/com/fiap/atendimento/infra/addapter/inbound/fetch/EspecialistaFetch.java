package br.com.fiap.atendimento.infra.addapter.inbound.fetch;

import br.com.fiap.atendimento.application.domain.especialista.Especialista;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto.EspecialistaDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "especialista", url = "http://localhost:8081/api/v1/especialista")
public interface EspecialistaFetch {
    @GetMapping(value = "listar")
    List<EspecialistaDTO> listar();

    @GetMapping(value = "/buscar/{id}")
    EspecialistaDTO buscar(@PathVariable(value = "id") String id);

    @GetMapping(value = "/localizar/{cep}")
    EspecialistaDTO localizar(@PathVariable(value = "cep") String cep);
}
