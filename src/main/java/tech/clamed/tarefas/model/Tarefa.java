package tech.clamed.tarefas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tarefa {

    private Long identificador;
    private String descricao;
    private Status status; // Status: pendente, em andamento, concluída
    private Prioridade prioridade; // Prioridade: baixa, média, alta
    private String nomeDoResponsavel;
}
