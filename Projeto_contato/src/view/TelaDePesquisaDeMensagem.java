package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControleDeMensagem;
import model.Contato;
import javax.swing.JScrollPane;

public class TelaDePesquisaDeMensagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoChavePesquisa;
	private String formaPesquisa;
	private JLabel lblChavePesquisa = new JLabel("");
	private ControleDeMensagem controllerMensagem;
	private Contato contato;
	JTable tabela = new JTable();

	private MenuPrincipal menuPrincipal = new MenuPrincipal();

	public TelaDePesquisaDeMensagem() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JLabel lblBuscaDeCliente = new JLabel("Busca de Mensgem");
		lblBuscaDeCliente.setFont(new Font("Dialog", Font.BOLD, 18));
		lblBuscaDeCliente.setBounds(269, 12, 188, 23);
		contentPane.add(lblBuscaDeCliente);

		JLabel lblSelecioneAForma = new JLabel("Selecione a forma de pesquisa:");
		lblSelecioneAForma.setBounds(31, 43, 231, 15);
		contentPane.add(lblSelecioneAForma);

		JRadioButton radioID = new JRadioButton("ID");
		radioID.setBounds(279, 39, 57, 23);
		radioID.setActionCommand("ID");
		contentPane.add(radioID);
		radioID.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblChavePesquisa.setText("Informe o ID");

			}
		});

		JRadioButton radioEmail = new JRadioButton("E-mail");
		radioEmail.setBounds(359, 39, 98, 23);
		radioEmail.setActionCommand("E-mail");
		contentPane.add(radioEmail);
		radioEmail.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				lblChavePesquisa.setText("Informe o E-mail");

			}
		});

		ButtonGroup grupoPesquisa = new ButtonGroup();
		grupoPesquisa.add(radioID);
		grupoPesquisa.add(radioEmail);

		lblChavePesquisa.setBounds(31, 77, 153, 15);
		contentPane.add(lblChavePesquisa);

		campoChavePesquisa = new JTextField();
		campoChavePesquisa.setBounds(202, 75, 322, 19);
		contentPane.add(campoChavePesquisa);
		campoChavePesquisa.setColumns(10);

		String[] nomesColunas = { "ID", "Nome", "E-mail", "Mensagem" };
		DefaultTableModel tableModel = new DefaultTableModel(nomesColunas, 0);
		tabela.setModel(tableModel);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(451, 209, 117, 25);
		btnBuscar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				formaPesquisa = grupoPesquisa.getSelection().getActionCommand();

				if (formaPesquisa.equals("ID")) {
					controllerMensagem = new ControleDeMensagem();

					contato = controllerMensagem.buscarPorId(campoChavePesquisa.getText());

					if (contato != null) {
						Object[] dados = { contato.getId(), contato.getNome(), contato.getEmail(),
								contato.getMensagem() };
						tableModel.addRow(dados);
					} else {
						JOptionPane.showMessageDialog(null, "Nenhum contato encontrado com esse Id.");
					}

				} else if (formaPesquisa.equals("E-mail")) {
					controllerMensagem = new ControleDeMensagem();
					contato = controllerMensagem.buscarPorEmail(campoChavePesquisa.getText());

					if (contato != null) {
						Object[] dados = { contato.getId(), contato.getNome(), contato.getEmail(),
								contato.getMensagem() };
						tableModel.addRow(dados);
					} else {
//						JOptionPane.showMessageDialog(null, "Nenhum contato encontrado com esse E-mail."+campoChavePesquisa.getText());
						JOptionPane.showMessageDialog(null, campoChavePesquisa.getText());
					}

				}
			}
		});
		contentPane.add(btnBuscar);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(322, 209, 117, 25);
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

		getContentPane().add(contentPane);

		JScrollPane scrollPaneTabela = new JScrollPane();
		scrollPaneTabela.setBounds(31, 116, 666, 67);
		scrollPaneTabela.getViewport().add(tabela);
		contentPane.add(scrollPaneTabela);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 312);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
