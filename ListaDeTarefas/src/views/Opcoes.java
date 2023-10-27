package views;

import java.text.ParseException;
import java.util.InputMismatchException;

import controllers.TarefaController;
import utils.Utils;

public class Opcoes {
	public static void opcoes() throws ParseException {
		// Criação do objeto utils para usar a função Menu(); do pacote utils
		Utils utils = new Utils();
		boolean rodar = true;
		
		// Criação do objeto TarefaController para usar as funções principais da aplicação
		TarefaController tc = new TarefaController();
		
		try {
			while(rodar) {
				int op = utils.Menu();
				
				switch (op) {
				case 0: {
					System.out.println("Programa encerrado!");
					rodar = false;
					break;
				}case 1: {
					tc.cadastrarTarefa();
					break;
				}case 2:{
					tc.atualizaStatus();
					break;
				}case 3:{
					tc.listarTarefas();
					break;
				}case 4:{
					tc.listarPorCategoria();
					break;
				}case 5:{
					tc.deletarTarefa();
					break;
				}
				default:
					throw new IllegalArgumentException("Valor inválido: ");
				}
			}
		}catch (InputMismatchException e) {
			System.out.println("Digite apenas números!");
		}catch(Exception e) {
			System.out.println("Erro ao rodar a aplicação: " +e);
		}
		
	}
}
