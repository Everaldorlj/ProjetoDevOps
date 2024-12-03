package br.com.everaldo.ProjetoDevOps.servico.repository;

import br.com.everaldo.ProjetoDevOps.servico.domain.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
