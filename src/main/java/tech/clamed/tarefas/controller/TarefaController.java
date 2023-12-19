package tech.clamed.tarefas.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.clamed.tarefas.dto.TarefaRequest;
import tech.clamed.tarefas.dto.TarefaResponse;
import tech.clamed.tarefas.model.Tarefa;
import tech.clamed.tarefas.repository.BancoDeDadosFicticio;

@RestController
public class TarefaController {

    @PostMapping("/tarefas")
    public ResponseEntity<TarefaResponse> criarTarefa(@RequestBody TarefaRequest tarefaRequest) {
        Tarefa tarefa = Tarefa.criarComId(tarefaRequest.getDescricao(), tarefaRequest.getStatus(), tarefaRequest.getPrioridade(), tarefaRequest.getNomeDoResponsavel());
        BancoDeDadosFicticio.salvarTarefa(tarefa);

        TarefaResponse tarefaResponse = new TarefaResponse(tarefa.getIdentificador(), tarefa.getDescricao(), tarefa.getStatus(), tarefa.getPrioridade(), tarefa.getNomeDoResponsavel());
        return ResponseEntity.ok(tarefaResponse);
    }

}
