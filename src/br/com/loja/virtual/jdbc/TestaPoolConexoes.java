package br.com.loja.virtual.jdbc;

import java.sql.SQLException;

import br.com.loja.virtual.jdbc.factory.ConnectionFactory;

public class TestaPoolConexoes {
	
	public static void main(String[] args) throws SQLException {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		
		for (int i = 0; i < 20; i++) {
			connectionFactory.conectaDatabase();
			System.out.println("Conexao de numero: " + i);
		}
	}
}
