package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro {
	public static void main(String[] args) throws SQLException {
		
		String nome = "Mouse'";
		String descricao = "Mouse sem fio); delete from Produto;";
		
		ConnectionFactory factory = new ConnectionFactory();
		Connection connection = factory.conectaDatabase();
		
		PreparedStatement stm = connection.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();
		
		ResultSet rst = stm.getGeneratedKeys();
		while (rst.next()) {
			Integer id = rst.getInt(1); // utilizamos o int columnIndex (no sql a 1ª coluna é considerada 1)
			System.out.println("O id criado foi: " + id);
		}
	}
}
