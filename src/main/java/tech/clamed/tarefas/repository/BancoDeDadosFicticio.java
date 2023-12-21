package tech.clamed.tarefas.repository;
import tech.clamed.tarefas.model.Prioridade;
import tech.clamed.tarefas.model.Status;
import tech.clamed.tarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class BancoDeDadosFicticio {
    private static final List<Tarefa> tarefas = new ArrayList<>();

    // Salvar uma tarefa na lista
    public static void salvarTarefa(Tarefa tarefa) {
        tarefas.add(tarefa);
    }

    // Remover uma tarefa da lista com base no identificador
    public static void removerTarefa(Long identificador) {
        tarefas.removeIf(tarefa -> tarefa.getIdentificador().equals(identificador));
    }

    // Listar as tarefas cadastradas
    public static List<Tarefa> listarTarefas() {
        return new ArrayList<>(tarefas);
    }

    // Listar as tarefas cadastradas com base no status
    public static List<Tarefa> listarTarefasPorStatus(Status status) {
        return tarefas.stream()
                .filter(tarefa -> tarefa.getStatus().equals(status))
                .collect(Collectors.toList());
    }

    // Listar as tarefas cadastradas com base na prioridade
    public static List<Tarefa> listarTarefasPorPrioridade(Prioridade prioridade) {
        return tarefas.stream()
                .filter(tarefa -> tarefa.getPrioridade().equals(prioridade))
                .collect(Collectors.toList());
    }

    // Listar as tarefas cadastradas com base no responsável
    public static List<Tarefa> listarTarefasPorResponsavel(String responsavel) {
        return tarefas.stream()
                .filter(tarefa -> tarefa.getNomeDoResponsavel().equalsIgnoreCase(responsavel))
                .collect(Collectors.toList());
    }

    //Lista as tarefas filtradas
    public static List<Tarefa> listarTarefasFiltradas(String owner, Status status, Prioridade priority) {
        return tarefas.stream()
                .filter(tarefa -> (owner == null || tarefa.getNomeDoResponsavel().equalsIgnoreCase(owner)) &&
                        (status == null || tarefa.getStatus() == status) &&
                        (priority == null || tarefa.getPrioridade() == priority))
                .collect(Collectors.toList());
    }
}
