package br.com.fiap.atendimento.application.domain.usuario;

import br.com.fiap.atendimento.application.domain.Status;
import br.com.fiap.atendimento.application.domain.address.Address;

public interface UsuarioFactory {
    Usuario newUsuario (String idUsuario, String nome, String cpf, Status status, Address endereco, String tell, String email);
}
