package tech.clamed.tarefas.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.clamed.tarefas.dto.TarefaRequest;
import tech.clamed.tarefas.dto.TarefaResponse;
import tech.clamed.tarefas.model.Prioridade;
import tech.clamed.tarefas.model.Status;
import tech.clamed.tarefas.model.Tarefa;
import tech.clamed.tarefas.repository.BancoDeDadosFicticio;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TarefaController {

    @PostMapping("/tarefas")
    public ResponseEntity<TarefaResponse> criarTarefa(@RequestBody TarefaRequest tarefaRequest) {
        Tarefa tarefa = Tarefa.criarComId(tarefaRequest.getDescricao(), tarefaRequest.getStatus(), tarefaRequest.getPrioridade(), tarefaRequest.getNomeDoResponsavel());
        BancoDeDadosFicticio.salvarTarefa(tarefa);

        TarefaResponse tarefaResponse = new TarefaResponse(tarefa.getIdentificador(), tarefa.getDescricao(), tarefa.getStatus(), tarefa.getPrioridade(), tarefa.getNomeDoResponsavel());
        return ResponseEntity.ok(tarefaResponse);
    }

    @GetMapping("/clamed/tarefas")
    public ResponseEntity<List<TarefaResponse>> listarTarefas(
            @RequestParam(required = false) String owner,
            @RequestParam(required = false) Status status,
            @RequestParam(required = false) Prioridade priority) {

        List<Tarefa> tarefasFiltradas = BancoDeDadosFicticio.listarTarefasFiltradas(owner, status, priority);
        List<TarefaResponse> responses = tarefasFiltradas.stream()
                .map(tarefa -> new TarefaResponse(tarefa.getIdentificador(), tarefa.getDescricao(), tarefa.getStatus(), tarefa.getPrioridade(), tarefa.getNomeDoResponsavel()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(responses);
    }

    //MODIFICA TAREFA
    @PutMapping("/tarefas/{identificador}")
    public ResponseEntity<TarefaResponse> atualizarTarefa(@PathVariable Long identificador, @RequestBody TarefaRequest tarefaRequest) {
        Tarefa tarefaAtualizada = BancoDeDadosFicticio.atualizarTarefa(identificador, tarefaRequest);

        if (tarefaAtualizada == null) {
            return ResponseEntity.notFound().build();
        }

        TarefaResponse tarefaResponse = new TarefaResponse(tarefaAtualizada.getIdentificador(), tarefaAtualizada.getDescricao(), tarefaAtualizada.getStatus(), tarefaAtualizada.getPrioridade(), tarefaAtualizada.getNomeDoResponsavel());
        return ResponseEntity.ok(tarefaResponse);
    }

    //DELETA TAREFA

    @DeleteMapping("/tarefas/{identificador}")
    public ResponseEntity<Void> removerTarefa(@PathVariable Long identificador) {
        boolean removido = BancoDeDadosFicticio.removerTarefa(identificador);
        if (removido) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
