package br.com.fiap.atendimento.application.domain.usuario;

import br.com.fiap.atendimento.application.domain.address.Address;
import br.com.fiap.atendimento.application.domain.Status;

public class Usuario {
    private final String idUsuario;
    private final String nome;
    private final String cpf;
    private final Status status;
    private final Address endereco;
    private final String tell;
    private final String email;

    public Usuario(UsuarioBuilder usuarioBuilder) {
        this.idUsuario = usuarioBuilder.idUsuario;
        this.nome = usuarioBuilder.nome;
        this.cpf = usuarioBuilder.cpf;
        this.status = usuarioBuilder.status;
        this.endereco = usuarioBuilder.endereco;
        this.tell = usuarioBuilder.tell;
        this.email = usuarioBuilder.email;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Status getStatus() {
        return status;
    }

    public Address getEndereco() {
        return endereco;
    }

    public String getTell() {
        return tell;
    }

    public String getEmail() {
        return email;
    }

    public static class UsuarioBuilder {
        private String idUsuario;
        private String nome;
        private String cpf;
        private Status status;
        private Address endereco;
        private String tell;
        private String email;

        public UsuarioBuilder withIdUsuario (String idUsuario) {
            this.idUsuario = idUsuario;
            return this;
        }

        public UsuarioBuilder withNome (String nome) {
            this.nome = nome;
            return this;
        }

        public UsuarioBuilder withCPF (String cpf) {
            this.cpf = cpf;
            return this;
        }

        public UsuarioBuilder withStatus (Status status) {
            this.status = status;
            return this;
        }

        public UsuarioBuilder withCep (Address endereco) {
            this.endereco = endereco;
            return this;
        }

        public UsuarioBuilder withTell (String tell) {
            this.tell = tell;
            return this;
        }

        public UsuarioBuilder withEmail (String email) {
            this.email = email;
            return this;
        }

        public Usuario build () {
            return new Usuario(this);
        }
    }
}
