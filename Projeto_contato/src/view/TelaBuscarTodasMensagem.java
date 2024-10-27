package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ControleDeMensagem;
import model.Contato;

public class TelaBuscarTodasMensagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClientesCadastrados = new JLabel("Mensagens Cadastradas");
	private JScrollPane scrollPane = new JScrollPane();
	private JButton btnVoltar = new JButton("Voltar");
	private JButton btnSair = new JButton("Sair");
	JTable tabela = new JTable();
	List<Contato> contatos = new ArrayList<Contato>();
	ControleDeMensagem controllerMensagem = new ControleDeMensagem();

	private MenuPrincipal menuPrincipal = new MenuPrincipal();

	public TelaBuscarTodasMensagem() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		lblClientesCadastrados.setBounds(251, 12, 282, 41);
		lblClientesCadastrados.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(lblClientesCadastrados);

		String[] nomesColunas = { "ID", "Nome", "E-mail", "Mensagem" };
		DefaultTableModel tableModel = new DefaultTableModel(nomesColunas, 0);
		tabela.setModel(tableModel);
		
		contatos = controllerMensagem.buscarTodos();

		if (!contatos.isEmpty()) {
			for (Contato contato : contatos) {
				Object[] dados = { contato.getId(), contato.getNome(), contato.getEmail(), contato.getMensagem() };
				tableModel.addRow(dados);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nenhum contato cadastrado");
		}

		scrollPane.setBounds(56, 83, 610, 144);
		scrollPane.getViewport().add(tabela);
		contentPane.add(scrollPane);

		btnVoltar.setBounds(550, 277, 117, 25);
		btnVoltar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVoltar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				menuPrincipal.setVisible(true);

			}
		});
		contentPane.add(btnVoltar);

		btnSair.setBounds(404, 277, 117, 25);
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
		setBounds(100, 100, 712, 362);
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
