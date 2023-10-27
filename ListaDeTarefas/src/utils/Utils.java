package utils;

import java.util.Scanner;

public class Utils {
	
	private static Scanner ler = new Scanner(System.in);
	
	public int Menu() {
		// Menu da aplicação que é chamado toda vez que termina uma execução de alguma função do TarefaController
		System.out.println("****** TODO ******");
		System.out.println("0 - SAIR");
		System.out.println("1 - CADASTRAR TAREFA");
		System.out.println("2 - MUDAR O STATUS");
		System.out.println("3 - LISTAR TAREFAS");
		System.out.println("4 - LISTAR POR CATEGORIA");
		System.out.println("5 - DELETAR TAREFA");
		int opcao = ler.nextInt();
		return opcao;
	}
}
