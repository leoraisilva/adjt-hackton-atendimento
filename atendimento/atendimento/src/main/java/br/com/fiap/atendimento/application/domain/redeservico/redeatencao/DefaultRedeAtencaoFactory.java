package br.com.fiap.atendimento.application.domain.redeservico.redeatencao;

public class DefaultRedeAtencaoFactory implements RedeAtencaoFactory{
    @Override
    public RedeAtencao newRedeAtencao(String idRede, String responsavel, TipoServico tipo, String descricao, String uf, String estado) {
        return new RedeAtencao.RedeAtencaoBuilder()
                .withIdRede(idRede)
                .withResponsavel(responsavel)
                .withTipo(tipo)
                .withDescricao(descricao)
                .withUf(uf)
                .withEstado(estado)
                .build();
    }
}
