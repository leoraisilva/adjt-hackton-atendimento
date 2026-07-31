package br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity;

import br.com.fiap.atendimento.application.domain.especialista.Especialista;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "exame_tb")
public class ExameEntity {

    @Id
    private String idExame;
    @Column(name = "area")
    private String area;
    @Column(name = "especialista")
    private String especialista;

    public ExameEntity(String idExame, String area, String especialista) {
        this.idExame = idExame;
        this.area = area;
        this.especialista = especialista;
    }

    public ExameEntity() {}

    public String getIdExame() {
        return idExame;
    }

    public void setIdExame(String idExame) {
        this.idExame = idExame;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getEspecialista() {
        return especialista;
    }

    public void setEspecialista(String especialista) {
        this.especialista = especialista;
    }

}
