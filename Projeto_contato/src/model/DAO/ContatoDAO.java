package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.Contato;
import util.Conexao;
import util.Configurador;

public class ContatoDAO {

	private static Configurador configurador = new Configurador();

	public static Contato inserir(String nome, String email, String mensagem) {
		Contato contato = null;

		Conexao conexao = new Conexao(configurador.getUrl(), configurador.getDriver(), configurador.getLogin(),
				configurador.getSenha());
		Connection con = conexao.obterConexao();

		String sql = "insert into contato(nome,email,mensagem) values (?,?,?)";

		try {
			PreparedStatement comando = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			comando.setString(1, nome);
			comando.setString(2, email);
			comando.setString(3, mensagem);

			if (comando.executeUpdate() > 0) {
				ResultSet rs = comando.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					contato = new Contato(id, nome, email, mensagem);
				}
				rs.close();
			}

			comando.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Erro ao iserir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}
		return contato;

	}

	public static List<Contato> buscarTodos() {
		List<Contato> Contato = new LinkedList<Contato>();

		Conexao conexao = new Conexao(configurador.getUrl(), configurador.getDriver(), configurador.getLogin(),
				configurador.getSenha());
		Connection con = conexao.obterConexao();

		String sql = "select * from contato";

		try {
			Statement comando = con.createStatement();

			ResultSet rs = comando.executeQuery(sql);

			while (rs.next()) {
				Contato contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setMensagem(rs.getString("mensagem"));

				Contato.add(contato);
			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Erro ao buscar no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}

		return Contato;
	}

	public static boolean excluir(int id) {
		boolean ok = false;

		Conexao conexao = new Conexao(configurador.getUrl(), configurador.getDriver(), configurador.getLogin(),
				configurador.getSenha());
		Connection con = conexao.obterConexao();

		String sql = "delete from contato where id=?";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, id);

			ok = comando.executeUpdate() > 0;

			comando.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Erro ao excluir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}
		return ok;
	}

	public static Contato buscarPorId(int id) {
		Contato contato = null;

		Conexao conexao = new Conexao(configurador.getUrl(), configurador.getDriver(), configurador.getLogin(),
				configurador.getSenha());
		Connection con = conexao.obterConexao();

		String sql = "select * from contato where id=?";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, id);

			ResultSet rs = comando.executeQuery();

			if (rs.next()) {
				contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setMensagem(rs.getString("mensagem"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Erro ao buscar por ID no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}
		return contato;
	}

	public static boolean atualizar(int id, String nome, String email, String mensagem) {
		boolean ok = false;

		Conexao conexao = new Conexao(configurador.getUrl(), configurador.getDriver(), configurador.getLogin(),
				configurador.getSenha());
		Connection con = conexao.obterConexao();

		String sql = "update contato set nome=?,email=?,mensagem=? where id=?";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, nome);
			comando.setString(2, email);
			comando.setString(3, mensagem);
			comando.setInt(4, id);

			ok = comando.executeUpdate() > 0;

			comando.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Erro ao atualizar no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}
		return ok;

	}

	public static Contato buscarPorEmail(String email) {

		Contato contato = null;

		Conexao conexao = new Conexao(configurador.getUrl(), configurador.getDriver(), configurador.getLogin(),
				configurador.getSenha());
		Connection con = conexao.obterConexao();

		String sql = "select * from contato where email=?";

		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, email);

			ResultSet rs = comando.executeQuery();

			while (rs.next()) {
				contato = new Contato();
				contato.setId(rs.getInt("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setMensagem(rs.getString("mensagem"));
			}

			rs.close();
			comando.close();
			con.close();

		} catch (SQLException e) {
			System.out.println("Erro ao buscar por e-mail no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: " + e.getMessage());
			e.printStackTrace();
		}
		return contato;

	}

}
