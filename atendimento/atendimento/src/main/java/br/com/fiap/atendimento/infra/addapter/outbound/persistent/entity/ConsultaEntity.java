package br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity;

import br.com.fiap.atendimento.application.domain.atendimento.Exame;
import br.com.fiap.atendimento.application.domain.especialista.Especialista;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "consulta_tb")
public class ConsultaEntity {
    @Id
    private String idConsulta;
    @Column(name = "responsavel", nullable = false)
    private String responsavel;
    @Column(name = "descricao")
    private String descricao;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "exames")
    private List<ExameEntity> exames;

    public ConsultaEntity(String idConsulta, String responsavel, String descricao, List<ExameEntity> exames) {
        this.idConsulta = idConsulta;
        this.responsavel = responsavel;
        this.descricao = descricao;
        this.exames = exames;
    }

    public ConsultaEntity() {}

    public String getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(String idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<ExameEntity> getExames() {
        return exames;
    }

    public void setExames(List<ExameEntity> exames) {
        this.exames = exames;
    }
}
