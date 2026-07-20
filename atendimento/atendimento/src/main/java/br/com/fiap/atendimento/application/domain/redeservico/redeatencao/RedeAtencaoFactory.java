package br.com.fiap.atendimento.application.domain.redeservico.redeatencao;

public interface RedeAtencaoFactory {
    RedeAtencao newRedeAtencao (String idRede, String responsavel, TipoServico tipo, String descricao, String uf, String estado);
}
