package br.com.everaldo.ProjetoDevOps.categoria.services;

import br.com.everaldo.ProjetoDevOps.categoria.domain.Categoria;
import br.com.everaldo.ProjetoDevOps.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> findById(Integer id) {
        return categoriaRepository.findById(id);
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria update(Integer id, Categoria categoria) {
        if (categoriaRepository.existsById(id)) {
            categoria.setIdCategoria(id);
            return categoriaRepository.save(categoria);
        } else {
            throw new RuntimeException("Categoria não encontrada");
        }
    }

    public void deleteById(Integer id) {
        if (categoriaRepository.existsById(id)) {
            categoriaRepository.deleteById(id);
        } else {
            throw new RuntimeException("Categoria não encontrada");
        }
    }
}
