package br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity;

import br.com.fiap.atendimento.application.domain.atendimento.Consulta;
import br.com.fiap.atendimento.application.domain.atendimento.Fluxo;
import br.com.fiap.atendimento.application.domain.redeservico.unidade.Unidade;
import br.com.fiap.atendimento.application.domain.usuario.Usuario;
import jakarta.persistence.*;

@Entity
@Table(name = "atendimento_tb")
public class AtendimentoEntity {
    @Id
    private String idAtendimento;
    @Column(name = "usuario", nullable = false)
    private String idUsuario;
    @Column(name = "unidade", nullable = false)
    private String idUnidade;
    @Column(name = "fluxo")
    private String fluxoAtendimento;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "consulta")
    private ConsultaEntity consulta;

    public AtendimentoEntity(String idAtendimento, String idUsuario, String idUnidade, String fluxoAtendimento, ConsultaEntity consulta) {
        this.idAtendimento = idAtendimento;
        this.idUsuario = idUsuario;
        this.idUnidade = idUnidade;
        this.fluxoAtendimento = fluxoAtendimento;
        this.consulta = consulta;
    }

    public AtendimentoEntity() {
    }

    public String getIdAtendimento() {
        return idAtendimento;
    }

    public void setIdAtendimento(String idAtendimento) {
        this.idAtendimento = idAtendimento;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getIdUnidade() {
        return idUnidade;
    }

    public void setIdUnidade(String idUnidade) {
        this.idUnidade = idUnidade;
    }

    public String getFluxoAtendimento() {
        return fluxoAtendimento;
    }

    public void setFluxoAtendimento(String fluxoAtendimento) {
        this.fluxoAtendimento = fluxoAtendimento;
    }

    public ConsultaEntity getConsulta() {
        return consulta;
    }

    public void setConsulta(ConsultaEntity consulta) {
        this.consulta = consulta;
    }

}
