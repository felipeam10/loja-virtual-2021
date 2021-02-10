package br.com.loja.virtual.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.loja.virtual.jdbc.dao.CategoriaDAO;
import br.com.loja.virtual.jdbc.dao.ProdutoDAO;
import br.com.loja.virtual.jdbc.modelo.Categoria;
import br.com.loja.virtual.jdbc.modelo.Produto;

public class TestaListagemDeCategorias {
	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().conectaDatabase()){
			CategoriaDAO categoriaDao = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDao.listar();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				try {
					for (Produto produto : new ProdutoDAO(connection).buscar(ct)) {
						System.out.println(ct.getNome() + " - " + produto.getNome());
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			});
		}
	}
}
