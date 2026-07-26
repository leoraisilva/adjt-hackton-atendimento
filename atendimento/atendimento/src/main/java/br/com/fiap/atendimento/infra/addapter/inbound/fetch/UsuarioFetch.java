package br.com.fiap.atendimento.infra.addapter.inbound.fetch;

import br.com.fiap.atendimento.application.domain.usuario.Usuario;
import br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "usuario",url = "http://localhost:8080/api/v1/usuario")
public interface UsuarioFetch {

    @GetMapping(value = "/list")
    List<UsuarioDTO> listUsuario();

    @GetMapping(value = "/search/{cpf}")
    UsuarioDTO getUsurio(@PathVariable(value = "cpf")String cpf);

}
