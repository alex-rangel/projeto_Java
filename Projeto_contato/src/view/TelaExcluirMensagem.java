package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.ControleDeMensagem;

public class TelaExcluirMensagem extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField campoChavePesquisa;
	private ControleDeMensagem controllerMensagem;

	private MenuPrincipal menuPrincipal = new MenuPrincipal();

	public TelaExcluirMensagem() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		JLabel lblExcluirCliente = new JLabel("Excluir Mensagem");
		lblExcluirCliente.setFont(new Font("Dialog", Font.BOLD, 18));
		lblExcluirCliente.setBounds(269, 12, 188, 25);
		contentPane.add(lblExcluirCliente);

		JLabel lblChaveParaExclusao = new JLabel("Informe o ID da Mensagem");
		lblChaveParaExclusao.setBounds(31, 77, 204, 15);
		contentPane.add(lblChaveParaExclusao);

		campoChavePesquisa = new JTextField();
		campoChavePesquisa.setBounds(239, 75, 65, 19);
		contentPane.add(campoChavePesquisa);
		campoChavePesquisa.setColumns(10);

		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(440, 209, 117, 25);
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

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(282, 209, 117, 25);
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int id = Integer.parseInt(campoChavePesquisa.getText());
				controllerMensagem = new ControleDeMensagem();
				boolean confirmacao =  controllerMensagem.apagarContato(id);
				
				if(confirmacao) {
					JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso.");
				}else {
					JOptionPane.showMessageDialog(null, "Falha ao excluir o usuário.");
				}

			}
		});
		contentPane.add(btnExcluir);

		getContentPane().add(contentPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 732, 312);
		setLocationRelativeTo(null);
		setResizable(false);
	}
}
