package br.com.fiap.atendimento.application.domain;

public class Address {
    private final String ibge;
    private final String cep;
    private final String logradouro;
    private final String complemento;
    private final String bairro;
    private final String localidade;
    private final String estado;
    private final String uf;

    public Address(AddressBuilder addressBuilder) {
        this.ibge = addressBuilder.ibge;
        this.cep = addressBuilder.cep;
        this.logradouro = addressBuilder.logradouro;
        this.complemento = addressBuilder.complemento;
        this.bairro = addressBuilder.bairro;
        this.localidade = addressBuilder.localidade;
        this.estado = addressBuilder.estado;
        this.uf = addressBuilder.uf;
    }

    public String getIbge() {
        return ibge;
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getUF() {
        return uf;
    }

    public static class AddressBuilder {
        private String ibge;
        private String cep;
        private String logradouro;
        private String complemento;
        private String bairro;
        private String localidade;
        private String estado;
        private String uf;

        public AddressBuilder withIBGE (String ibge) {
            this.ibge = ibge;
            return this;
        }

        public AddressBuilder withCEP (String cep) {
            this.cep = cep;
            return this;
        }

        public AddressBuilder withLogradouro (String logradouro) {
            this.logradouro = logradouro;
            return this;
        }

        public AddressBuilder withComplemento (String complemento) {
            this.complemento = complemento;
            return this;
        }

        public AddressBuilder withBairro (String bairro) {
            this.bairro = bairro;
            return this;
        }

        public AddressBuilder withLocalidade (String localidade) {
            this.localidade = localidade;
            return this;
        }

        public AddressBuilder withEstado (String estado) {
            this.estado = estado;
            return this;
        }

        public AddressBuilder withUF (String uf) {
            this.uf = uf;
            return this;
        }

        public Address build (){
            return new Address(this);
        }
    }
}
