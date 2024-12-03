package br.com.everaldo.ProjetoDevOps.servico.service;

import br.com.everaldo.ProjetoDevOps.servico.domain.Servico;
import br.com.everaldo.ProjetoDevOps.servico.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository servicoRepository;

    public List<Servico> findAll() {
        return servicoRepository.findAll();
    }

    public Optional<Servico> findById(Integer id) {
        return servicoRepository.findById(id);
    }

    public Servico save(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Servico update(Integer id, Servico servico) {
        if (servicoRepository.existsById(id)) {
            servico.setIdServico(id);
            return servicoRepository.save(servico);
        } else {
            throw new RuntimeException("Serviço não encontrado");
        }
    }

    public void deleteById(Integer id) {
        if (servicoRepository.existsById(id)) {
            servicoRepository.deleteById(id);
        } else {
            throw new RuntimeException("Serviço não encontrado");
        }
    }
}
