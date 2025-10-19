package tarefas_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tarefas_api.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}