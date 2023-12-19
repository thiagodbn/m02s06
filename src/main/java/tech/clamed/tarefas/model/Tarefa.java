package tech.clamed.tarefas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tarefa {

    private static Long contadorId = 1L;

    private Long identificador;
    private String descricao;
    private Status status; // Status: pendente, em andamento, concluída
    private Prioridade prioridade; // Prioridade: baixa, média, alta
    private String nomeDoResponsavel;

    // Método de fábrica para criar uma tarefa com ID gerado automaticamente
    public static Tarefa criarComId(String descricao, Status status, Prioridade prioridade, String nomeDoResponsavel) {
        Tarefa tarefa = new Tarefa();
        tarefa.identificador = contadorId++;
        tarefa.descricao = descricao;
        tarefa.status = status;
        tarefa.prioridade = prioridade;
        tarefa.nomeDoResponsavel = nomeDoResponsavel;
        return tarefa;
    }
}
