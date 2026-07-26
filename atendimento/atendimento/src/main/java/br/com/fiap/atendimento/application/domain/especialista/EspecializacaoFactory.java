package br.com.fiap.atendimento.application.domain.especialista;

public interface EspecializacaoFactory {
    Especializacao newEspecializacao (String idEspecializacao, Tipo tipo, String area);
}
