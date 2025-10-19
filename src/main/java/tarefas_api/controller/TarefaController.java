package tarefas_api.controller;

import tarefas_api.model.Tarefa;
import tarefas_api.repository.TarefaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaRepository repo;

    public TarefaController(TarefaRepository repo) {
        this.repo = repo;
    }

    // LISTAR TODAS
    @GetMapping
    public List<Tarefa> listar() {
        return repo.findAll();
    }

    // BUSCAR POR ID
    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscar(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // CRIAR
    @PostMapping
    public ResponseEntity<Tarefa> criar(@RequestBody Tarefa body) {
        Tarefa salva = repo.save(body);
        return ResponseEntity
                .created(URI.create("/tarefas/" + salva.getId()))
                .body(salva);
    }

    // ATUALIZAR
    @PutMapping("/{id}")
    public ResponseEntity<Tarefa> atualizar(@PathVariable Long id, @RequestBody Tarefa body) {
        return repo.findById(id).map(existente -> {
            existente.setNome(body.getNome());
            existente.setDataEntrega(body.getDataEntrega());
            existente.setResponsavel(body.getResponsavel());
            Tarefa atualizado = repo.save(existente);
            return ResponseEntity.ok(atualizado);
        }).orElse(ResponseEntity.notFound().build());
    }

    // REMOVER
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        return repo.findById(id)
                .map(t -> {
                    repo.deleteById(id);
                    return ResponseEntity.noContent().<Void>build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}