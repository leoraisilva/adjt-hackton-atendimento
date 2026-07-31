package br.com.fiap.atendimento.application.usecase.outbound;

import br.com.fiap.atendimento.application.domain.atendimento.Atendimento;

import java.util.List;

public interface AtendimentoRepository {
    Atendimento gerar(Atendimento input);
    Atendimento atualizar (Atendimento input);
    Atendimento buscar (String idAtendimento);
    Atendimento cancelar (String idAtendimento);
    List<Atendimento> listar ();
    Atendimento marcar (Atendimento atendimento, List<String> exames);
}
