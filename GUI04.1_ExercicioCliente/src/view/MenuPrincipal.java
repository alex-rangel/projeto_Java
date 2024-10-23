package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MenuPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblMenuPrincipal = new JLabel("Menu Principal");
	private JButton botaoCadastrar = new JButton("Cadastrar");
	private JButton btnMostrarTodos = new JButton("Buscar Todos clientes");
	private JButton btnBuscarCliente = new JButton("Buscar cliente");
	private JButton btnExcluirCliente = new JButton("Excluir Cliente");
	private JButton btnSair = new JButton("Sair");

	private TelaDeCadastro telaDeCadastro;
	private TelaBuscarTodos telaBuscarTodosClientes;
	private TelaDePesquisaDeCliente telaPesquisaCliente;
	private TelaExcluirCliente telaExcluirCliente;

	public MenuPrincipal() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		lblMenuPrincipal.setFont(new Font("Dialog", Font.BOLD, 15));
		lblMenuPrincipal.setBounds(133, 25, 138, 31);
		contentPane.add(lblMenuPrincipal);

		botaoCadastrar.setBounds(33, 81, 318, 41);
		botaoCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		botaoCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				telaDeCadastro = new TelaDeCadastro();
				telaDeCadastro.setVisible(true);

			}
		});
		contentPane.add(botaoCadastrar);

		btnMostrarTodos.setBounds(33, 134, 318, 41);
		btnMostrarTodos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnMostrarTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				telaBuscarTodosClientes = new TelaBuscarTodos();
				telaBuscarTodosClientes.setVisible(true);

			}
		});
		contentPane.add(btnMostrarTodos);

		btnBuscarCliente.setBounds(33, 187, 318, 41);
		btnBuscarCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBuscarCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				telaPesquisaCliente = new TelaDePesquisaDeCliente();
				telaPesquisaCliente.setVisible(true);

			}
		});
		contentPane.add(btnBuscarCliente);

		btnExcluirCliente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluirCliente.setBounds(33, 240, 318, 41);
		btnExcluirCliente.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				telaExcluirCliente = new TelaExcluirCliente();
				telaExcluirCliente.setVisible(true);

			}
		});
		contentPane.add(btnExcluirCliente);

		btnSair.setBounds(244, 329, 107, 31);
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		contentPane.add(btnSair);

		getContentPane().add(contentPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 376, 415);
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
