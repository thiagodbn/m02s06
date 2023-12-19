package tech.clamed.tarefas.dto;

import lombok.Data;
import tech.clamed.tarefas.model.Prioridade;
import tech.clamed.tarefas.model.Status;

@Data
public class TarefaRequest {

    private String descricao;
    private Status status;
    private Prioridade prioridade;
    private String nomeDoResponsavel;

}
