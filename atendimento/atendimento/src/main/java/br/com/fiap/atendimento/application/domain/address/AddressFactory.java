package br.com.fiap.atendimento.application.domain.address;

public interface AddressFactory {
    Address newAddress (String cep, String codigoMunicipio, String logradouro, String complemento, String bairro, String localidade, String estado, String uf);
}
