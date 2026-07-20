package br.com.fiap.atendimento.infra.addapter.outbound.persistent.repository;

import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.ConsultaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaJpaRepository extends JpaRepository<ConsultaEntity, String> {
}
