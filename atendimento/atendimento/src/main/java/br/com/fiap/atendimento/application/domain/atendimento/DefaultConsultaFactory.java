package br.com.fiap.atendimento.application.domain.atendimento;

import br.com.fiap.atendimento.application.domain.especialista.Especialista;

import java.util.List;

public class DefaultConsultaFactory implements ConsultaFactory{
    @Override
    public Consulta newConsulta(String idConsulta, Especialista responsavel, String descricao, List<Exame> exames) {
        return new Consulta.ConsultaBuilder()
                .withIdConsulta(idConsulta)
                .withResponsavel(responsavel)
                .withDescricao(descricao)
                .withExames(exames)
                .build();
    }
}
