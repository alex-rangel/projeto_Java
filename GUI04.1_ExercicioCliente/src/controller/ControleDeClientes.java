package controller;

import view.MenuPrincipal;
import view.TelaBuscarTodos;

public class ControleDeClientes {


//	private void cadastrarCliente() {
//		System.out.println("--Cadastrar Cliente--");
//		String nome = Teclado.lerTexto("Nome:");
//		String cpf = Teclado.lerTexto("CPF.:");
//		String email = Teclado.lerTexto("E-mail:");
//
//		Cliente cliente = ClienteDAO.inserir(nome, cpf, email);
//
//		if (cliente != null) {
//			System.out.println("Cliente cadastrado com sucesso.");
//			System.out.println(cliente);
//		} else {
//			System.out.println("Erro ao inserir cliente.");
//		}
//
//	}
//
//	private void visualizarTodosClientes() {
//		System.out.println("--Visualizar Clientes--");
//		List<Cliente> clientes = ClienteDAO.buscarTodos();
//		if (!clientes.isEmpty()) {
//			for (Cliente cliente : clientes) {
//				System.out.println(cliente);
//				System.out.println();
//			}
//		} else {
//			System.out.println("Nenhum cliente cadastrado.");
//		}
//	}
//
//	private void apagarCliente() {
//		System.out.println("--Apagar Cliente--");
//		int id = Teclado.lerInt("ID:");
//		Cliente cliente = ClienteDAO.buscarPorId(id);
//		if (cliente != null) {
//			System.out.println(cliente);
//			String conf = Teclado.lerTexto("Deseja realmente excluir o cliente acima?(Sim ou Não)");
//			if (conf.equalsIgnoreCase("sim")) {
//				if (ClienteDAO.excluir(id)) {
//					System.out.println("Cliente excluído com sucesso.");
//				} else {
//					System.out.println("Erro ao excluir cliente.");
//				}
//			} else {
//				System.out.println("Procedimento cancelado.");
//			}
//		} else {
//			System.out.println("Erro ao excluir cliente ou clilente inexistente.");
//		}
//	}
//
//	private void atualizarCliente() {
//		System.out.println("--Atualizar Cliente--");
//		int id = Teclado.lerInt("ID:");
//		Cliente cliente = ClienteDAO.buscarPorId(id);
//		if (cliente != null) {
//			System.out.println("Nome atual: " + cliente.getNome());
//			String nome = Teclado.lerTexto("Informe o novo nome ou ENTER para manter o atual:");
//			if (nome.equals("")) {
//				nome = cliente.getNome();
//			}
//
//			System.out.println("CPF atual: " + cliente.getCpf());
//			String cpf = Teclado.lerTexto("Informe o novo CPF ou ENTER para manter o atual:");
//			if (cpf.equals("")) {
//				cpf = cliente.getCpf();
//			}
//
//			System.out.println("E-mail atual: " + cliente.getEmail());
//			String email = Teclado.lerTexto("Informe o novo e-mail ou ENTER para manter o atual:");
//			if (email.equals("")) {
//				email = cliente.getEmail();
//			}
//
//			if (ClienteDAO.atualizar(id, nome, cpf, email)) {
//				System.out.println("Clilente atualizado com sucesso.");
//			} else {
//				System.out.println("Erro ao atualizar cliente.");
//			}
//
//		} else {
//			System.out.println("Erro ao atualizar cliente ou cliente inexitente.");
//		}
//	}
//
//	private void buscarPorId() {
//		System.out.println("--Buscar por ID--");
//		int id = Teclado.lerInt("ID:");
//		Cliente cliente = ClienteDAO.buscarPorId(id);
//		if (cliente != null) {
//			System.out.println(cliente);
//		} else {
//			System.out.println("Erro ao buscar cliente ou cliente inexistente.");
//		}
//	}
//
//	private void buscarPorEmail() {
//		System.out.println("--Buscar por E-mail--");
//		String email = Teclado.lerTexto("E-mail:");
//		List<Cliente> clientes = ClienteDAO.buscarPorEmail(email);
//		if (!clientes.isEmpty()) {
//			for (Cliente cliente : clientes) {
//				System.out.println(cliente);
//			}
//		} else {
//			System.out.println("Nenhum cliente encontrado.");
//		}
//	}

}
