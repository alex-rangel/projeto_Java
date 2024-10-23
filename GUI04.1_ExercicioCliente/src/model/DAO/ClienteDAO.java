package model.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import model.Cliente;
import util.Conexao;
import util.Configurador;

public class ClienteDAO {

	private static Configurador configurador = new Configurador(); 
	
	public static Cliente inserir(String nome,String cpf,String email) {
		Cliente cliente = null;
		
		Conexao conexao = new Conexao(configurador.getUrl(),configurador.getDriver(),
				configurador.getLogin(),configurador.getSenha());
		Connection con = conexao.obterConexao();
		
		String sql = "insert into cliente(nome,cpf,email) values (?,?,?)";
		
		try {
			PreparedStatement comando = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			comando.setString(1, nome);
			comando.setString(2, cpf);
			comando.setString(3, email);
			
			if(comando.executeUpdate() > 0) {
				ResultSet rs = comando.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					cliente = new Cliente(id, nome, cpf, email);
				}
				rs.close();
			}
			
			comando.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao iserir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: "+e.getMessage());
			e.printStackTrace();
		}
		return cliente;
		
	}
	
	public static List<Cliente> buscarTodos(){
		List<Cliente> clientes = new LinkedList<Cliente>();
		
		Conexao conexao = new Conexao(configurador.getUrl(),configurador.getDriver(),
				configurador.getLogin(),configurador.getSenha());
		Connection con = conexao.obterConexao();
		
		String sql = "select * from cliente";
		
		try {
			Statement comando = con.createStatement();
			
			ResultSet rs = comando.executeQuery(sql);
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				
				clientes.add(cliente);
			}
			
			rs.close();
			comando.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: "+e.getMessage());
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	public static boolean excluir(int id) {
		boolean ok = false;
		
		Conexao conexao = new Conexao(configurador.getUrl(),configurador.getDriver(),
				configurador.getLogin(),configurador.getSenha());
		Connection con = conexao.obterConexao();
		
		String sql = "delete from cliente where id=?";
		
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, id);
			
			ok = comando.executeUpdate() > 0;
			
			comando.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao excluir no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: "+e.getMessage());
			e.printStackTrace();
		}
		return ok;
	}
	
	public static Cliente buscarPorId(int id) {
		Cliente cliente = null;
		
		Conexao conexao = new Conexao(configurador.getUrl(),configurador.getDriver(),
				configurador.getLogin(),configurador.getSenha());
		Connection con = conexao.obterConexao();
		
		String sql = "select * from cliente where id=?";
		
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setInt(1, id);
			
			ResultSet rs = comando.executeQuery();
			
			if(rs.next()) {
				cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));				
			}
			
			rs.close();
			comando.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar por ID no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: "+e.getMessage());
			e.printStackTrace();
		}
		return cliente;		
	}
	
	public static boolean atualizar(int id,String nome,String cpf,String email) {
		boolean ok = false;
		
		Conexao conexao = new Conexao(configurador.getUrl(),configurador.getDriver(),
				configurador.getLogin(),configurador.getSenha());
		Connection con = conexao.obterConexao();
		
		String sql = "update cliente set nome=?,cpf=?,email=? where id=?";
		
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, nome);
			comando.setString(2, cpf);
			comando.setString(3, email);
			comando.setInt(4, id);
			
			ok = comando.executeUpdate() > 0;
			
			comando.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao atualizar no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: "+e.getMessage());
			e.printStackTrace();
		}
		return ok;
		
	}
	
	public static List<Cliente> buscarPorEmail(String email){
		List<Cliente> clientes = new LinkedList<Cliente>();
		
		Conexao conexao = new Conexao(configurador.getUrl(),configurador.getDriver(),
				configurador.getLogin(),configurador.getSenha());
		Connection con = conexao.obterConexao();
		
		String sql = "select * from cliente where email=?";
		
		try {
			PreparedStatement comando = con.prepareStatement(sql);
			comando.setString(1, email);
			
			ResultSet rs = comando.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente();
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				
				clientes.add(cliente);
			}
			
			rs.close();
			comando.close();
			con.close();
			
		} catch (SQLException e) {
			System.out.println("Erro ao buscar por e-mail no Banco de Dados.");
			System.out.println("Verifique sua instrução SQL.");
			System.out.println("Mensagem de erro: "+e.getMessage());
			e.printStackTrace();
		}
		return clientes;
		
	}

	
	
	
	
	
	
	
	
	
	
}
