package tech.clamed.tarefas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tech.clamed.tarefas.model.Prioridade;
import tech.clamed.tarefas.model.Status;
import tech.clamed.tarefas.model.Tarefa;
import tech.clamed.tarefas.repository.BancoDeDadosFicticio;

@SpringBootApplication
public class M02S06Application {

	public static void main(String[] args) {
		SpringApplication.run(M02S06Application.class, args);


		//TESTE DO BANCO DE DADOS FICTICIO
		// Criar tarefas
		Tarefa tarefa1 = new Tarefa(1L, "Descrição da Tarefa 1", Status.PENDENTE, Prioridade.ALTA, "João");
		Tarefa tarefa2 = new Tarefa(2L, "Descrição da Tarefa 2", Status.EM_ANDAMENTO, Prioridade.MEDIA, "Maria");

		// Salvar tarefas
		BancoDeDadosFicticio.salvarTarefa(tarefa1);
		BancoDeDadosFicticio.salvarTarefa(tarefa2);

		// Listar tarefas
		System.out.println("Tarefas cadastradas: " + BancoDeDadosFicticio.listarTarefas());

		// Remover uma tarefa
		BancoDeDadosFicticio.removerTarefa(1L);

		// Listar tarefas após remoção
		System.out.println("Tarefas após remoção: " + BancoDeDadosFicticio.listarTarefas());


	}


}
