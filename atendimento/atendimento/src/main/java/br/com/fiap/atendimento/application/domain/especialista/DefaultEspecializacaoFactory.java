package br.com.fiap.atendimento.application.domain.especialista;

public class DefaultEspecializacaoFactory implements EspecializacaoFactory{
    @Override
    public Especializacao newEspecializacao(String idEspecializacao, Tipo tipo, String area) {
        return new Especializacao.EspecializacaoBuilder()
                .withIdEspecializacao(idEspecializacao)
                .withTipo(tipo)
                .withArea(area)
                .build();
    }
}
