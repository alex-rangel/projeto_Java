package view;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class TelaBuscarTodos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblClientesCadastrados = new JLabel("Clientes Cadastrados");
	private JScrollPane scrollPane = new JScrollPane();
	private JButton btnVoltar = new JButton("Voltar");
	private JButton btnSair = new JButton("Sair");

	private MenuPrincipal menuPrincipal = new MenuPrincipal();

	public TelaBuscarTodos() {

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		lblClientesCadastrados.setBounds(251, 12, 282, 41);
		lblClientesCadastrados.setFont(new Font("Dialog", Font.BOLD, 20));
		contentPane.add(lblClientesCadastrados);

		scrollPane.setBounds(56, 83, 610, 144);
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

		add(contentPane);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 712, 362);
		setLocationRelativeTo(null);
		setResizable(false);
	}

}
