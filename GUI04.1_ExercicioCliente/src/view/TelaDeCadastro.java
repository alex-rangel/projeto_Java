package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaDeCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoCPF;
	private JTextField campoNome;
	private JTextField campoEmail;

	private MenuPrincipal menuPrincipal = new MenuPrincipal();

	public TelaDeCadastro() {

		contentPane = new JPanel();
		contentPane.setBackground(new Color(181, 131, 90));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JLabel lblCadastrarCliente = new JLabel("Cadastrar Cliente");
		lblCadastrarCliente.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCadastrarCliente.setBounds(212, 12, 211, 56);
		contentPane.add(lblCadastrarCliente);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 118, 123));
		panel.setBounds(107, 80, 447, 247);
		contentPane.add(panel);
		panel.setLayout(null);

		campoCPF = new JTextField();
		campoCPF.setColumns(10);
		campoCPF.setBounds(117, 121, 235, 26);
		panel.add(campoCPF);

		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setBounds(117, 108, 70, 15);
		panel.add(lblCPF);

		campoNome = new JTextField();
		campoNome.setColumns(10);
		campoNome.setBounds(117, 55, 235, 26);
		panel.add(campoNome);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(117, 39, 70, 15);
		panel.add(lblNome);

		campoEmail = new JTextField();
		campoEmail.setColumns(10);
		campoEmail.setBounds(117, 195, 235, 26);
		panel.add(campoEmail);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(117, 179, 70, 15);
		panel.add(lblEmail);

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

		add(contentPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 454);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
