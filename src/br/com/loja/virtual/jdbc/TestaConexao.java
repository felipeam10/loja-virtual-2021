package br.com.loja.virtual.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

public class TestaConexao {
	public static void main(String[] args) throws SQLException {
		// o metodo getConnection abre uma conexao
//		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC", "root", "admin");
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.conectaDatabase();
		
		System.out.println("Fechando conexão");
		connection.close();
	}
}
