package tech.clamed.tarefas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.clamed.tarefas.model.Prioridade;
import tech.clamed.tarefas.model.Status;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaResponse {

    private Long identificador;
    private String descricao;
    private Status status;
    private Prioridade prioridade;
    private String nomeDoResponsavel;

}
