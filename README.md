# 📋 Tarefas API

Este mini projeto de gerenciamento de tarefas é a atividade do módulo 2 da semana 6 do curso DEVinHouse, turma Clamed. Ele fornece uma API RESTful para gerenciamento de tarefas, utilizando Spring Boot, permitindo a criação, listagem, atualização e remoção de tarefas com atributos como identificador, descrição, status, prioridade e responsável.

## Autor
- **Thiago D. B. Noronha**

## 🏗 Estrutura do Projeto

### Modelos 📐
- `Tarefa`: Representa a entidade tarefa com atributos como identificador, descrição, status, prioridade e nome do responsável.
- `Status`: Enumeração dos estados da tarefa (PENDENTE, EM_ANDAMENTO, CONCLUÍDA).
- `Prioridade`: Enumeração das prioridades da tarefa (BAIXA, MEDIA, ALTA).

### Repositório 🗃
- `BancoDeDadosFicticio`: Simula um banco de dados em memória para gerenciar as tarefas.

### Controladores 🎮
- `TarefaController`: Gerencia as operações CRUD das tarefas.
- `BemVindoController`: Fornece uma mensagem de boas-vindas.

## 🔌 Endpoints

### TarefaController
- **Criar Tarefa** ➕
  - **POST** `/tarefas`
  - Cria uma nova tarefa.

- **Listar Tarefas** 📋
  - **GET** `/clamed/tarefas`
  - Lista todas as tarefas ou filtra tarefas por responsável, status e prioridade.

- **Atualizar Tarefa** 🔄
  - **PUT** `/tarefas/{identificador}`
  - Atualiza a tarefa com o identificador especificado.

- **Remover Tarefa** ❌
  - **DELETE** `/tarefas/{identificador}`
  - Remove a tarefa com o identificador especificado.

### BemVindoController 🤗
- **Mensagem de Boas-Vindas** 👋
  - **GET** `/clamed/hello`
  - Retorna uma mensagem de boas-vindas.

## 💡 Exemplos de Uso

- Consultar todas as tarefas: `GET http://localhost:8080/tarefas`
- Consultar tarefas com status PENDENTE: `GET http://localhost:8080/clamed/tarefas?status=PENDENTE`
- Criar uma nova tarefa: `POST http://localhost:8080/tarefas`
