package br.com.fiap.atendimento.infra.addapter.inbound.fetch;

import br.com.fiap.atendimento.application.domain.redeservico.territorio.Territorio;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto.AddressDTO;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto.TerritorioDTO;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto.UnidadeDTO;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto.UnidadeResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(value = "redeatencao", url = "http://localhost:8082/api/v1/redeatencao")
public interface RedeAtencaoFetch {
    @GetMapping(value = "/unidade/listar")
    List<UnidadeResponseDTO > listarUnidade();

    @GetMapping(value = "/unidade/buscar/{id}")
    UnidadeResponseDTO buscarUnidade(@PathVariable(value = "id") String id);

    @GetMapping(value = "/territorio/localizar/{id}")
    TerritorioDTO localizarTerritorio(@PathVariable(value = "id") String id);

    @GetMapping(value = "/unidade/comparar")
    List<UnidadeResponseDTO> comparar(@RequestBody AddressDTO addressDTO);

    @GetMapping(value = "/territorio/enderecar")
    AddressDTO enderecar(@RequestBody UnidadeDTO unidadeDTO);
}
