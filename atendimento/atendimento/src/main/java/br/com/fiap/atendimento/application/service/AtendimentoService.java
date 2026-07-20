package br.com.fiap.atendimento.application.service;

import br.com.fiap.atendimento.application.usecase.inbound.AtendimentoPort;
import br.com.fiap.atendimento.application.usecase.inbound.atualizar.AtualizarInput;
import br.com.fiap.atendimento.application.usecase.inbound.atualizar.AtualizarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.buscar.BuscarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.cancelar.CancelarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.gerar.GerarInput;
import br.com.fiap.atendimento.application.usecase.inbound.gerar.GerarOutput;
import br.com.fiap.atendimento.application.usecase.inbound.listar.ListarOutput;
import br.com.fiap.atendimento.application.usecase.outbound.AtendimentoRepository;

import java.util.List;

public class AtendimentoService implements AtendimentoPort {
    private final AtendimentoRepository atendimentoRepository;

    public AtendimentoService(AtendimentoRepository atendimentoRepository) {
        this.atendimentoRepository = atendimentoRepository;
    }

    @Override
    public GerarOutput gerar(GerarInput input) {
        return GerarOutput.from(atendimentoRepository.gerar(GerarInput.to(input)));
    }

    @Override
    public AtualizarOutput atualizar(AtualizarInput input) {
        return AtualizarOutput.from(atendimentoRepository.atualizar(AtualizarInput.to(input)));
    }

    @Override
    public BuscarOutput buscar(String idAtendimento) {
        return BuscarOutput.from(atendimentoRepository.buscar(idAtendimento));
    }

    @Override
    public CancelarOutput cancelar(String idAtendimento) {
        return CancelarOutput.from(atendimentoRepository.cancelar(idAtendimento));
    }

    @Override
    public List<ListarOutput> listar() {
        return atendimentoRepository.listar().stream()
                .map(ListarOutput::from)
                .toList();
    }
}
