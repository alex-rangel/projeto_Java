package controller;

import java.util.List;

import model.Cliente;
import model.DAO.ClienteDAO;
import util.Teclado;

public class ControleDeClientesModelo {

	private static final int CADASTRAR_CLIENTE = 1;
	private static final int VISUALIZAR_TODOS_CLIENTES = 2;
	private static final int APAGAR_CLIENTE = 3;
	private static final int ATUALIZAR_CLIENTE = 4;
	private static final int BUSCAR_POR_ID = 5;
	private static final int BUSCAR_POR_EMAIL = 6;
	private static final int SAIR = 7;

	private void mostrarMenu() {
		System.out.println(">>>-Cadastro de Clientes-<<<");
		System.out.println("1 - Cadastrar cliente.");
		System.out.println("2 - Mostrar todos os clientes.");
		System.out.println("3 - Apagar cliente.");
		System.out.println("4 - Atualizar cliente.");
		System.out.println("5 - Buscar cliente por ID.");
		System.out.println("6 - Buscar cliente por e-mail.");
		System.out.println("7 - Sair");
	}

	private void cadastrarCliente() {
		System.out.println("--Cadastrar Cliente--");
		String nome = Teclado.lerTexto("Nome:");
		String cpf = Teclado.lerTexto("CPF.:");
		String email = Teclado.lerTexto("E-mail:");

		Cliente cliente = ClienteDAO.inserir(nome, cpf, email);

		if(cliente != null) {
			System.out.println("Cliente cadastrado com sucesso.");
			System.out.println(cliente);
		}else {
			System.out.println("Erro ao inserir cliente.");
		}

	}

	private void visualizarTodosClientes() {
		System.out.println("--Visualizar Clientes--");
		List<Cliente> clientes = ClienteDAO.buscarTodos();
		if(!clientes.isEmpty()) {
			for(Cliente cliente : clientes) {
				System.out.println(cliente);
				System.out.println();
			}
		}else {
			System.out.println("Nenhum cliente cadastrado.");
		}
	}

	private void apagarCliente() {
		System.out.println("--Apagar Cliente--");
		int id = Teclado.lerInt("ID:");
		Cliente cliente = ClienteDAO.buscarPorId(id);
		if(cliente != null) {
			System.out.println(cliente);
			String conf = Teclado.lerTexto("Deseja realmente excluir o cliente acima?(Sim ou Não)");
			if(conf.equalsIgnoreCase("sim")) {
				if(ClienteDAO.excluir(id)) {
					System.out.println("Cliente excluído com sucesso.");
				}else {
					System.out.println("Erro ao excluir cliente.");
				}
			}else {
				System.out.println("Procedimento cancelado.");
			}
		}else {
			System.out.println("Erro ao excluir cliente ou clilente inexistente.");
		}
	}


	private void atualizarCliente() {
		System.out.println("--Atualizar Cliente--");
		int id = Teclado.lerInt("ID:");
		Cliente cliente = ClienteDAO.buscarPorId(id);
		if(cliente != null) {
			System.out.println("Nome atual: "+cliente.getNome());
			String nome = Teclado.lerTexto("Informe o novo nome ou ENTER para manter o atual:");
			if(nome.equals("")) {
				nome = cliente.getNome();
			}

			System.out.println("CPF atual: "+cliente.getCpf());
			String cpf = Teclado.lerTexto("Informe o novo CPF ou ENTER para manter o atual:");
			if(cpf.equals("")) {
				cpf = cliente.getCpf();
			}

			System.out.println("E-mail atual: "+cliente.getEmail());
			String email = Teclado.lerTexto("Informe o novo e-mail ou ENTER para manter o atual:");
			if(email.equals("")) {
				email = cliente.getEmail();
			}

			if(ClienteDAO.atualizar(id, nome, cpf, email)) {
				System.out.println("Clilente atualizado com sucesso.");
			}else {
				System.out.println("Erro ao atualizar cliente.");
			}

		}else {
			System.out.println("Erro ao atualizar cliente ou cliente inexitente.");
		}
	}

	private void buscarPorId() {
		System.out.println("--Buscar por ID--");
		int id = Teclado.lerInt("ID:");
		Cliente cliente = ClienteDAO.buscarPorId(id);
		if(cliente != null) {
			System.out.println(cliente);
		}else {
			System.out.println("Erro ao buscar cliente ou cliente inexistente.");
		}
	}

	private void buscarPorEmail() {
		System.out.println("--Buscar por E-mail--");
		String email = Teclado.lerTexto("E-mail:");
		List<Cliente> clientes = ClienteDAO.buscarPorEmail(email);
		if(!clientes.isEmpty()) {
			for (Cliente cliente : clientes) {
				System.out.println(cliente);
			}
		}else{
			System.out.println("Nenhum cliente encontrado.");
		}
	}


//	public static void main(String[] args) {
//		ControleDeClientesModelo cdc = new ControleDeClientesModelo();
//		 int opcao = SAIR;
//		 
//		 do {
//			 cdc.mostrarMenu();
//			 opcao = Teclado.lerInt("Opção:");
//			 switch(opcao) {
//			 case CADASTRAR_CLIENTE:
//				 cdc.cadastrarCliente();
//				 break;
//			 case VISUALIZAR_TODOS_CLIENTES:
//				 cdc.visualizarTodosClientes();
//				 break;
//			 case APAGAR_CLIENTE:
//				 cdc.apagarCliente();
//				 break;
//			 case ATUALIZAR_CLIENTE:
//				 cdc.atualizarCliente();
//				 break;
//			 case BUSCAR_POR_ID:
//				 cdc.buscarPorId();
//				 break;
//			 case BUSCAR_POR_EMAIL:
//				 cdc.buscarPorEmail();
//				 break;
//			 case SAIR:
//				 System.out.println("Saindo do sistema...");
//				 break;
//			 default:
//				 System.out.println("Opção inválida.");
//				 break;
//			 }
//			 Teclado.lerTexto("\nPressione ENTER para continuar...\n");
//		 }while(opcao != SAIR);
//		 System.out.println("Sistema encerrado.");
//	}
}
