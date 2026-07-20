package br.com.fiap.atendimento.application.domain.atendimento;

import br.com.fiap.atendimento.application.domain.especialista.Especialista;

public class DefaultExameFactory implements ExameFactory{
    @Override
    public Exame newExame(String idExame, String area, Especialista especialista) {
        return new Exame.ExameBuilder()
                .withIdExame(idExame)
                .withArea(area)
                .withEspecialista(especialista)
                .build();
    }
}
