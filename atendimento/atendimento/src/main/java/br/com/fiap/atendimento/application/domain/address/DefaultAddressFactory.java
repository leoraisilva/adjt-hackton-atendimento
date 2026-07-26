package br.com.fiap.atendimento.application.domain.address;

public class DefaultAddressFactory implements AddressFactory {
    @Override
    public Address newAddress(String cep, String codigoMunicipio, String logradouro, String complemento, String bairro, String localidade, String estado, String uf) {
        return new Address.AddressBuilder()
                .withCEP(cep)
                .withCodigoMunicipio(codigoMunicipio)
                .withLogradouro(logradouro)
                .withComplemento(complemento)
                .withBairro(bairro)
                .withLocalidade(localidade)
                .withEstado(estado)
                .withUF(uf)
                .build();
    }
}
