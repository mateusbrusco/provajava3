package provajava;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

/**
 * @author Mateus Brusco de Freitas
 * @author Luana do Amaral Lucera
 * @author Matheus Adão Franciosi
 * @version 1.0
 * @since 2022-05-29
 */

public class ConectaBD {
	// Inicializa variáveis utilizadas
	public ResultSet rs = null;
	public ResultSet rsMoto = null;
	private ResultSet rsVendas = null;
	private Connection conexao = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;

	final private String host = "localhost";
	final private String user = "root";
	final private String passwd = "";

	// Método para cadastrar novo cliente no banco de dados
	public void cadastraCliente(String nome, String cpf, String dataNasc, String telefone, String email, String endereco, String numero, String complemento, String cidade, String estado) throws Exception {
		try {
			// Carrega o driver MySQL
			Class.forName("com.mysql.jdbc.Driver");

			// Configura a conexão com o banco de dados
			conexao = DriverManager
					.getConnection("jdbc:mysql://" + host + "/paraisoduasrodas?" + "user=" + user + "&password=" + passwd);

			// Cria declaração 
			statement = conexao.createStatement();
			// Cria e executa uma consulta sql para cadastrar novo cliente
			String sql = "INSERT INTO cadastroclientes values('" + nome + "','" + cpf + "','" + dataNasc + "','" + telefone + "','" + email + "','" + endereco + "','" + numero + "','" + complemento + "','" + cidade + "','" + estado + "')";
			statement.executeUpdate(sql);
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}
	
	// Método para buscar cliente no banco de dados
	public void buscaCliente(String nome) throws Exception {
		
		try {

			Class.forName("com.mysql.jdbc.Driver");


			conexao = DriverManager
					.getConnection("jdbc:mysql://" + host + "/paraisoduasrodas?" + "user=" + user + "&password=" + passwd);


			statement = conexao.createStatement();
			// Cria e executa uma consulta sql para buscar correspondências com o nome de cliente informado
			String sql = "SELECT * FROM cadastroclientes WHERE nome = '" + nome + "'";
			rs = statement.executeQuery(sql);
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			//close();
		}
	}
	
	// Método para cadastrar nova moto no banco de dados
	public void cadastraMoto(String modeloMoto, String marcaMoto, String placa, String cor, int anoFabrica, int anoModelo, double km, double valor) throws Exception {
		try {

			Class.forName("com.mysql.jdbc.Driver");


			conexao = DriverManager
					.getConnection("jdbc:mysql://" + host + "/paraisoduasrodas?" + "user=" + user + "&password=" + passwd);


			statement = conexao.createStatement();
			// Cria e executa uma consulta sql para cadastrar nova moto
			String sql = "INSERT INTO cadastromotos values('" + modeloMoto + "','" + marcaMoto + "','" + placa + "','" + cor + "','" + anoFabrica + "','" + anoModelo + "','" + km + "','" + valor + "')";
			statement.executeUpdate(sql);
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}
	
	// Método para cadastrar nova venda no banco de dados
	public void cadastraVenda(String nome, String cpf, String endereco, String numero, String modelo, String marca, String placa, int ano, double valor) throws Exception {
		try {

			Class.forName("com.mysql.jdbc.Driver");


			conexao = DriverManager
					.getConnection("jdbc:mysql://" + host + "/paraisoduasrodas?" + "user=" + user + "&password=" + passwd);


			statement = conexao.createStatement();
			// Cria e executa uma consulta sql para cadastrar nova venda
			String sql = "INSERT INTO cadastrovendas values('" + nome + "','" + cpf + "','" + endereco + "','" + numero + "','" + modelo + "','" + marca + "','" + placa + "','" + ano + "','" + valor + "')";
			statement.executeUpdate(sql);
			apagaMoto(placa);
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}

	}


	// Método para buscar moto no banco de dados
	public void buscaMoto(String placa) throws Exception {
		
		try {

			Class.forName("com.mysql.jdbc.Driver");


			conexao = DriverManager
					.getConnection("jdbc:mysql://" + host + "/paraisoduasrodas?" + "user=" + user + "&password=" + passwd);


			statement = conexao.createStatement();
			// Cria e executa uma consulta sql para buscar correspondências com a placa de moto informada
			String sql = "SELECT * FROM cadastromotos WHERE placa = '" + placa + "'";
			rsMoto = statement.executeQuery(sql);
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			//close();
		}
	}
	
	// Método para remover registro de moto do banco de dados após venda
	public void apagaMoto(String placa) throws Exception {
		
		try {

			Class.forName("com.mysql.jdbc.Driver");


			conexao = DriverManager
					.getConnection("jdbc:mysql://" + host + "/paraisoduasrodas?" + "user=" + user + "&password=" + passwd);


			statement = conexao.createStatement();
			// Cria e executa uma consulta sql para buscar correspondências com a placa de moto informada e remover registro
			String sql = "DELETE FROM cadastromotos WHERE placa = '" + placa + "'";
			statement.executeUpdate(sql);
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			//close();
		}
	}
	
	public void atualizaCadastroCliente(String nome, String cpf, String dataNasc, String telefone, String email, String endereco, String numero, String complemento, String cidade, String estado) throws Exception {
		PreparedStatement stmt = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");


			conexao = DriverManager
					.getConnection("jdbc:mysql://" + host + "/paraisoduasrodas?" + "user=" + user + "&password=" + passwd);


			stmt = conexao.prepareStatement("UPDATE cadastroclientes SET nome = ?, cpf = ?, dataNascimento = ?, telefone = ?, email = ?, endereco = ?, complemento = ?, cidade = ?, estado = ?");
			stmt.setString(1, nome);
			stmt.setString(2, cpf);
			stmt.setString(3, dataNasc);
			stmt.setString(4, telefone);
			stmt.setString(5, email);
			stmt.setString(6, endereco);
			stmt.setString(7, complemento);
			stmt.setString(8, cidade);
			stmt.setString(9, estado);
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	public void atualizaCadastroMoto(String modelo, String marca, String placa, String cor, int anoFab, int anoMod, double km, double valor) throws Exception {
		PreparedStatement stmt = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver");


			conexao = DriverManager
					.getConnection("jdbc:mysql://" + host + "/paraisoduasrodas?" + "user=" + user + "&password=" + passwd);


			stmt = conexao.prepareStatement("UPDATE cadastromotos SET modelo = ?, marca = ?, placa = ?, cor = ?, anoFabricacao = ?, anoModelo = ?, km = ?, valor = ?");
			stmt.setString(1, modelo);
			stmt.setString(2, marca);
			stmt.setString(3, placa);
			stmt.setString(4, cor);
			stmt.setInt(5, anoFab);
			stmt.setInt(6, anoMod);
			stmt.setDouble(7, km);
			stmt.setDouble(8, valor);
			
			stmt.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			close();
		}
	}
	
	public void buscaVendas() throws Exception {
		
		try {

			Class.forName("com.mysql.jdbc.Driver");


			conexao = DriverManager
					.getConnection("jdbc:mysql://" + host + "/paraisoduasrodas?" + "user=" + user + "&password=" + passwd);


			statement = conexao.createStatement();
			// Cria e executa uma consulta sql para buscar correspondências com a placa de moto informada
			String sql = "SELECT * FROM cadastrovendas";
			rsVendas = statement.executeQuery(sql);
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			//close();
		}
	}
	
	public ResultSet getVendas() {
		return rsVendas;
	}

	
	
	// Fecha o ResultSet
	private void close() {
		try {
			if (resultSet != null) {
				resultSet.close();
			}

			if (statement != null) {
				statement.close();
			}

			if (conexao != null) {
				conexao.close();
			}
		} catch (Exception e) {

		}
	}

}