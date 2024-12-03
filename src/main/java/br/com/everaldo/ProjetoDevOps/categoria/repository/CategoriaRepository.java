package br.com.everaldo.ProjetoDevOps.categoria.repository;

import br.com.everaldo.ProjetoDevOps.categoria.domain.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Integer> {
}
