package br.com.fiap.atendimento.application.domain.usuario;

import br.com.fiap.atendimento.application.domain.Status;
import br.com.fiap.atendimento.application.domain.address.Address;

public class DefaultUsuarioFactory implements UsuarioFactory {

    @Override
    public Usuario newUsuario(String idUsuario, String nome, String cpf, Status status, Address endereco, String tell, String email) {
        return new Usuario.UsuarioBuilder()
                .withIdUsuario(idUsuario)
                .withNome(nome)
                .withCPF(cpf)
                .withStatus(status)
                .withCep(endereco)
                .withTell(tell)
                .withEmail(email)
                .build();
    }
}
