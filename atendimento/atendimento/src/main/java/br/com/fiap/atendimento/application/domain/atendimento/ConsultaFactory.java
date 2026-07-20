package br.com.fiap.atendimento.application.domain.atendimento;

import br.com.fiap.atendimento.application.domain.especialista.Especialista;

import java.util.List;

public interface ConsultaFactory {
    Consulta newConsulta (String idConsulta, Especialista responsavel, String descricao, List<Exame> exames);
}
