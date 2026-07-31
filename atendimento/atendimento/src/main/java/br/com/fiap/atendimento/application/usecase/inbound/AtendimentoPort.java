package br.com.fiap.atendimento.application.usecase.inbound;

import br.com.fiap.atendimento.application.usecase.inbound.atualizar.AtualizarInput;
import br.com.fiap.atendimento.application.usecase.inbound.atualizar.AtualizarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.buscar.BuscarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.cancelar.CancelarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.gerar.GerarInput;
import br.com.fiap.atendimento.application.usecase.inbound.gerar.GerarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.listar.ListarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.marcar.MarcarInput;
import br.com.fiap.atendimento.application.usecase.inbound.marcar.MarcarOutput;

import java.util.List;

public interface AtendimentoPort {
    GerarOutput gerar (GerarInput input);
    AtualizarOutput atualizar (AtualizarInput input);
    BuscarOutput buscar (String idAtendimento);
    CancelarOutput cancelar (String idAtendimento);
    List<ListarOutput> listar ();
    MarcarOutput marcar (MarcarInput input);
}
