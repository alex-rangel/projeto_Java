package view;

import java.awt.Color;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControleDeMensagem;
import javax.swing.JScrollPane;

public class TelaDeCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoEmail;
	private JTextField campoNome;

	private ControleDeMensagem controllerMensagem;
	private MenuPrincipal menuPrincipal = new MenuPrincipal();

	public TelaDeCadastro() {

		contentPane = new JPanel();
		contentPane.setBackground(new Color(181, 131, 90));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JLabel lblCadastrarMensagem = new JLabel("Cadastrar Mensagem");
		lblCadastrarMensagem.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCadastrarMensagem.setBounds(212, 12, 211, 56);
		contentPane.add(lblCadastrarMensagem);

		JPanel painelPrincipal = new JPanel();
		painelPrincipal.setBackground(new Color(119, 118, 123));
		painelPrincipal.setBounds(107, 80, 447, 247);
		contentPane.add(painelPrincipal);
		painelPrincipal.setLayout(null);

		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		campoEmail.setBounds(117, 76, 235, 26);
		painelPrincipal.add(campoEmail);

		JLabel lblEmail = new JLabel("E-mail");
		lblEmail.setBounds(117, 61, 70, 15);
		painelPrincipal.add(lblEmail);

		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(117, 24, 235, 26);
		painelPrincipal.add(campoNome);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(117, 11, 70, 15);
		painelPrincipal.add(lblNome);

		JLabel lblMensagem = new JLabel("Mensagem");
		lblMensagem.setBounds(117, 113, 114, 15);
		painelPrincipal.add(lblMensagem);

		JTextArea campoMensagem = new JTextArea(5, 15);
		campoMensagem.setBounds(117, 128, 235, 95);
		campoMensagem.setLineWrap(true);
		campoMensagem.setWrapStyleWord(true);

		JScrollPane scrollPane = new JScrollPane(campoMensagem);
		scrollPane.setBounds(117, 130, 235, 105);
		painelPrincipal.add(scrollPane);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.setBounds(107, 358, 119, 25);
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				menuPrincipal.setVisible(true);

			}
		});
		contentPane.add(btnVoltar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCadastrar.setBounds(278, 358, 119, 25);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = campoNome.getText();
				String email = campoEmail.getText();
				String mensagem = campoMensagem.getText();

				controllerMensagem = new ControleDeMensagem();

				boolean confCadastroContato = controllerMensagem.cadastrarCliente(nome, email, mensagem);

				if (confCadastroContato) {
					JOptionPane.showMessageDialog(btnCadastrar, "Usuário cadastrado com sucesso!!!");
				} else {
					JOptionPane.showMessageDialog(btnCadastrar, "Erro ao cadastrar o usuário");
				}
			}
		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(435, 358, 119, 25);
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		contentPane.add(btnCancelar);

		getContentPane().add(contentPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 454);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
