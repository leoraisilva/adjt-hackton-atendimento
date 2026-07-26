package br.com.fiap.atendimento.infra.addapter.inbound.fetch.dto;

import br.com.fiap.atendimento.application.domain.address.Address;

public record AddressDTO (String cep, String codigoMunicipio, String logradouro, String complemento, String bairro, String localidade, String estado, String UF) {
    public static Address to (AddressDTO addressDTO) {
        return new Address.AddressBuilder()
                .withCEP(addressDTO.cep())
                .withCodigoMunicipio(addressDTO.codigoMunicipio())
                .withLogradouro(addressDTO.logradouro())
                .withComplemento(addressDTO.complemento())
                .withBairro(addressDTO.bairro())
                .withLocalidade(addressDTO.localidade())
                .withEstado(addressDTO.estado())
                .withUF(addressDTO.UF())
                .build();
    }
}
