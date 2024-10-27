package controller;

import java.util.List;

import model.Contato;
import model.DAO.ContatoDAO;

public class ControleDeMensagem {

	public boolean cadastrarCliente(String nome, String email, String mensagem) {

		Contato contato = ContatoDAO.inserir(nome, email, mensagem);

		if (contato != null) {
			return true;
		} else {
			return false;
		}

	}

	public List<Contato> buscarTodos() {

		List<Contato> contatos = ContatoDAO.buscarTodos();
		return contatos;
	}

	public boolean apagarContato(int id) {
		
		boolean confirmacao = ContatoDAO.excluir(id);
		
		return confirmacao;
		
	}
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

	public Contato buscarPorId(String Id) {

		int id = Integer.parseInt(Id);

		Contato contato = ContatoDAO.buscarPorId(id);

		return contato;
	}

	public Contato buscarPorEmail(String email) {

		Contato contato = ContatoDAO.buscarPorEmail(email);

		return contato;
	}

}
