package controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import models.Status;
import models.Tarefas;

public class TarefaController {
	private static Scanner ler = new Scanner(System.in);
	private static List<Tarefas> tarefas = new ArrayList<Tarefas>();
	
	// Método que busca uma tarefa pelo id que o usuário informar
    public Tarefas buscarTarefa(List<Tarefas> tarefas, int id) {
        for (Tarefas tarefa : tarefas) {
            if (tarefa.getId() == id) {
                return tarefa;
            }
        }
        return null;
    }
	
    // Insere a tabela em uma lista
	public void cadastrarTarefa() throws ParseException {
		Tarefas tarefa = new Tarefas();
		
		try {
			System.out.println("****** CADASTRO DE TAREFA ******");
			System.out.println("Digite a descrição da tarefa: ");
			tarefa.setDescricao(ler.nextLine());
			System.out.println("Digite o prazo da tarefa (formato dd/MM/yyyy):");
			String data = ler.nextLine();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date date = dateFormat.parse(data);
			tarefa.setPrazo(date);
			tarefa.setStatus(Status.PARA_FAZER);
			
			tarefas.add(tarefa);
			System.out.println("Tarefa cadastrada com sucesso!");
		}catch (ParseException e) {
			System.out.println("Digite um formato de data válida");
		}catch (Exception e) {
			System.out.println("Erro ao cadastrar uma tarefa");
		}
	}
	
	// Deleta a tarefa pelo id informado pelo usuário
	public void deletarTarefa() {
		if(tarefas.isEmpty()) {
			System.out.println("A lista está vazia");
		}else {
			try {
				System.out.println("****** DELEÇÃO DA TAREFA ******");
				System.out.println("Digite o ID da tarefa para ser deletada: ");
				int id = ler.nextInt();
				Tarefas tarefa = buscarTarefa(tarefas, id);
				if(tarefa != null ) {
					tarefas.remove(tarefa);
					System.out.println("Tarefa deletada com sucesso!");
				}else {
					System.out.println("Tarefa não encontrada!");
				}
			} catch (InputMismatchException e) {
				System.out.println("Digite apenas números no ID");
			}catch (Exception e) {
				System.out.println("Erro ao deletar tarefa: " +e);
			}
		}
	}
	
	// Atualiza o status da tarefa de acordo com os status disponíveis pelo ENUM Status.java
	public void atualizaStatus() {
		try {
			if(tarefas.isEmpty()) {
				System.out.println("A lista de tarefas está vazia");
			}else {
				System.out.println("****** ATUALIZAR STATUS DA TAREFA ******");
				System.out.println("Digite o id da tarefa: ");
				int id = ler.nextInt();
				ler.nextLine();
				Tarefas tarefa = buscarTarefa(tarefas, id);
				if(tarefa != null) {
					System.out.println("Tarefa encontrada!");
					System.out.println("Digite o novo status dela: [ESPERANDO, FEITO, PARA FAZER, TRABALHANDO]");
					String status = ler.nextLine();
					tarefa.setStatus(Status.valueOf(status.toUpperCase()));
					System.out.println(tarefa);
				}else {
					System.out.println("Tarefa não encontrada!");
				}	
			}
			
		}catch (InputMismatchException e) {
			System.out.println("No id digite apenas números");
		}catch (IllegalArgumentException e) {
			System.out.println("Digite na mudança de status apenas os possíveis campos");
		}catch (Exception e) {
			System.out.println("Erro ao atualizar status: " +e);
		}
			
	}
	
	// Lista todas as tarefas inseridas
	public void listarTarefas() {
		if(tarefas.isEmpty()) {
			System.out.println("A lista de tarefas está vazia");
		}else {
			System.out.println("****** LISTANDO AS TAREFAS ******");
			for (Tarefas tarefas : tarefas) {
				System.out.println(tarefas);
			}
		}
		
	}
		
	// Agrupa e lista as tarefas por categoria
	public void listarPorCategoria() {
        if (tarefas.isEmpty()) {
            System.out.println("A lista de tarefas está vazia");
        } else {
            System.out.println("****** LISTANDO POR CATEGORIA ******");

            Map<Status, List<Tarefas>> tarefasPorStatus = agruparTarefasPorStatus();

            for (Status status : Status.values()) {
                List<Tarefas> tarefasNoStatus = tarefasPorStatus.getOrDefault(status, new ArrayList<>());

                if (!tarefasNoStatus.isEmpty()) {
                    System.out.println("****** " + status + " ******");
                    for (Tarefas task : tarefasNoStatus) {
                        System.out.println(task);
                    }
                }
            }
        }
    }

    private Map<Status, List<Tarefas>> agruparTarefasPorStatus() {
        Map<Status, List<Tarefas>> tarefasPorStatus = new HashMap<>();

        for (Tarefas task : tarefas) {
            tarefasPorStatus.computeIfAbsent(task.getStatus(), k -> new ArrayList<>()).add(task);
        }

        return tarefasPorStatus;
    }
}
