package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class TelaDePesquisaDeCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoChavePesquisa;

	private MenuPrincipal menuPrincipal = new MenuPrincipal();

	public TelaDePesquisaDeCliente() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JLabel lblBuscaDeCliente = new JLabel("Busca de Cliente");
		lblBuscaDeCliente.setFont(new Font("Dialog", Font.BOLD, 18));
		lblBuscaDeCliente.setBounds(269, 12, 188, 15);
		contentPane.add(lblBuscaDeCliente);

		JLabel lblSelecioneAForma = new JLabel("Selecione a forma de pesquisa:");
		lblSelecioneAForma.setBounds(31, 43, 231, 15);
		contentPane.add(lblSelecioneAForma);

		JRadioButton radioCPF = new JRadioButton("CPf");
		radioCPF.setBounds(279, 39, 57, 23);
		contentPane.add(radioCPF);

		JRadioButton radioEmail = new JRadioButton("E-mail");
		radioEmail.setBounds(359, 39, 98, 23);
		contentPane.add(radioEmail);

		JLabel lblChavePesquisa = new JLabel("Informe o ");
		lblChavePesquisa.setBounds(31, 77, 153, 15);
		contentPane.add(lblChavePesquisa);

		campoChavePesquisa = new JTextField();
		campoChavePesquisa.setBounds(202, 75, 322, 19);
		contentPane.add(campoChavePesquisa);
		campoChavePesquisa.setColumns(10);

		JPanel panel = new JPanel();
		panel.setBounds(45, 118, 650, 38);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(434, 209, 117, 25);
		btnSair.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});
		contentPane.add(btnSair);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(580, 209, 117, 25);
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				dispose();
				menuPrincipal.setVisible(true);

			}
		});
		contentPane.add(btnVoltar);

		add(contentPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 312);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
