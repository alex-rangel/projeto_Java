package controller;

import java.util.List;

import model.Contato;
import model.DAO.ContatoDAO;
import util.Teclado;

public class ControleDeContatos {
	
	private static final int CADASTRAR_MENSAGEM = 1;
	private static final int VISUALIZAR_MENSAGEM = 2;
	private static final int APAGAR_MENSAGEM = 3;
	private static final int ATUALIZAR_MENSAGEM = 4;
	private static final int BUSCAR_POR_ID = 5;
	private static final int BUSCAR_POR_EMAIL = 6;
	private static final int SAIR = 7;
	
	private void mostrarMenu() {
		System.out.println("=========================");
		System.out.println("==Cadastro de Mensagens==");
		System.out.println("=========================");
		System.out.println("1 - Cadastrar mensagem.");
		System.out.println("2 - Mostrar mensagem.");
		System.out.println("3 - Apagar mensagem.");
		System.out.println("4 - Atualizar mensagem.");
		System.out.println("5 - Buscar mensagem por ID.");
		System.out.println("6 - Buscar por e-mail.");
		System.out.println("7 - Sair");
		
	}
	
	private void cadastrarMensagem() {
		System.out.println("====================");
		System.out.println("=Cadastrar Mensagem=");
		System.out.println("====================");
		String nome = Teclado.lerTexto("Nome:");
		String email = Teclado.lerTexto("E-mail:");
		String mensagem = Teclado.lerTexto("Mensagem:");
		
		Contato contato = ContatoDAO.inserir(nome, email, mensagem);
		
		if(contato != null) {
			System.out.println("Contato inserido com sucesso.");
			System.out.println(contato);
		}else {
			System.out.println("Erro ao inserir contato.");
		}
	}
	
	private void visualizarMensagem() {
		System.out.println("======================");
		System.out.println("=Visualizar Mensagens=");
		System.out.println("======================");
		List<Contato> contatos = ContatoDAO.buscarTodos();
		if(!contatos.isEmpty()) {
			for (Contato contato : contatos) {
				System.out.println(contato);
				System.out.println();
			}
		}else {
			System.out.println("Nenhum registro encontrado.");
		}
	}
	
	private void apagarMensagem() {
		System.out.println("=================");
		System.out.println("=Apagar Mensagem=");
		System.out.println("=================");
		int id = Teclado.lerInt("ID:");
		Contato contato = ContatoDAO.buscarPorId(id);
		if(contato != null) {
			System.out.println(contato);
			String conf = Teclado.lerTexto("Deseja realmente excluir a mensagem acima?(Sim ou Não)");
			if(conf.equalsIgnoreCase("sim")) {
				if(ContatoDAO.excluir(id)) {
					System.out.println("Mensagem excluída com sucesso.");
				}else {
					System.out.println("Erro ao excluir mensagem.");
				}
			}else {
				System.out.println("Procedimento cancelado.");
			}
		}else {
			System.out.println("Erro ao excluir mensagem ou mensagem inexistente.");
		}
		
	}
	
	private void buscarPorId() {
		System.out.println("========================");
		System.out.println("=Buscar Mensagem Por ID=");
		System.out.println("========================");
		int id = Teclado.lerInt("ID:");
		Contato contato = ContatoDAO.buscarPorId(id);
		if(contato != null) {
			System.out.println(contato);
		}else {
			System.out.println("Erro ao buscar contato ou contato inexistente.");
		}
	}
	
	private void atualizarMensagem() {
		System.out.println("====================");
		System.out.println("=Atualizar Mensagem=");
		System.out.println("====================");
		int id = Teclado.lerInt("ID:");
		Contato contato = ContatoDAO.buscarPorId(id);
		if(contato != null) {
			System.out.println(contato);
			String mensagem = Teclado.lerTexto("Nova mensagem:");
			if(ContatoDAO.atualizar(id, mensagem)) {
				System.out.println("Mensagem atualizada com sucesso.");
			}else {
				System.out.println("Erro ao atualizar mensagem.");
			}
			
		}else {
			System.out.println("Erro ao atualizar mensagem ou mensagem inexistente.");
		}
	}
	
	private void buscarPorEmail() {
		System.out.println("============================");
		System.out.println("=Buscar Mensagem por E-mail=");
		System.out.println("============================");
		String email = Teclado.lerTexto("E-mail:");
		List<Contato> contatos = ContatoDAO.buscarPorEmail(email);
		if(!contatos.isEmpty()) {
			for(int i=0;i<contatos.size();i++) {
				System.out.println(contatos.get(i));
				System.out.println();
			}
		}else {
			System.out.println("Mensagem não encontrada.");
		}
	}

	public static void main(String[] args) {
		ControleDeContatos cdc = new ControleDeContatos();
		
		int opcao = SAIR;
		do {
			cdc.mostrarMenu();
			opcao = Teclado.lerInt("Opção: ");
			switch (opcao) {
			case CADASTRAR_MENSAGEM:
				cdc.cadastrarMensagem();
				break;
			case VISUALIZAR_MENSAGEM:
				cdc.visualizarMensagem();
				break;
			case APAGAR_MENSAGEM:
				cdc.apagarMensagem();
				break;
			case ATUALIZAR_MENSAGEM:
				cdc.atualizarMensagem();
				break;
			case BUSCAR_POR_ID:
				cdc.buscarPorId();
				break;
			case BUSCAR_POR_EMAIL:
				cdc.buscarPorEmail();
				break;
			case SAIR:
				System.out.println("Saindo do sistema...");
				break;				
			default:
				System.out.println("Opção inválida.");
				break;
			}
			Teclado.lerTexto("\nPressione ENTER para continuar...\n");
		}while(opcao != SAIR);
		System.out.println("Sistema encerrado.");
	}

}
