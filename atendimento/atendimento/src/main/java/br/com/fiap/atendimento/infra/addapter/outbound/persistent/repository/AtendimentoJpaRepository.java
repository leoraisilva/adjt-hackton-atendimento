package br.com.fiap.atendimento.infra.addapter.outbound.persistent.repository;

import br.com.fiap.atendimento.infra.addapter.outbound.persistent.entity.AtendimentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtendimentoJpaRepository extends JpaRepository<AtendimentoEntity, String> {
}
