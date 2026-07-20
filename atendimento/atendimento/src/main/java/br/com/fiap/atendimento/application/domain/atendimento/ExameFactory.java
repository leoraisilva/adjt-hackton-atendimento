package br.com.fiap.atendimento.application.domain.atendimento;

import br.com.fiap.atendimento.application.domain.especialista.Especialista;

public interface ExameFactory {
    Exame newExame (String idExame, String area, Especialista especialista);
}
