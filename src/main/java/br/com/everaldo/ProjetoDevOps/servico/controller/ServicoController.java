package br.com.everaldo.ProjetoDevOps.servico.controller;

import br.com.everaldo.ProjetoDevOps.servico.domain.Servico;
import br.com.everaldo.ProjetoDevOps.servico.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicos")
public class ServicoController {

    @Autowired
    private ServicoService servicoService;

    @GetMapping
    public ResponseEntity<List<Servico>> getAll() {
        List<Servico> servicos = servicoService.findAll();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Servico> getById(@PathVariable Integer id) {
        return servicoService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Servico> create(@RequestBody Servico servico) {
        Servico novoServico = servicoService.save(servico);
        return ResponseEntity.ok(novoServico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> update(@PathVariable Integer id, @RequestBody Servico servico) {
        try {
            Servico servicoAtualizado = servicoService.update(id, servico);
            return ResponseEntity.ok(servicoAtualizado);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        try {
            servicoService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
