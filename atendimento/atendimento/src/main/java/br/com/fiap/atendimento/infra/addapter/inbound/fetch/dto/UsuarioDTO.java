package br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto;

import br.com.fiap.atendimento.application.domain.Status;
import br.com.fiap.atendimento.application.domain.address.Address;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;

public record UsuarioDTO(String idUsuario, String nome, String cpf, Status status, AddressDTO endereco, String tell, String email) {
    public static Usuario to (UsuarioDTO usuarioDTO) {
        return new Usuario.UsuarioBuilder()
                .withIdUsuario(usuarioDTO.idUsuario())
                .withNome(usuarioDTO.nome())
                .withCPF(usuarioDTO.cpf())
                .withStatus(usuarioDTO.status())
                .withEmail(usuarioDTO.email())
                .withCep(AddressDTO.to(usuarioDTO.endereco()))
                .withTell(usuarioDTO.tell())
                .build();
    }
}
