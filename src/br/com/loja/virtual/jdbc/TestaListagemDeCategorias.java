package br.com.loja.virtual.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.loja.virtual.jdbc.dao.CategoriaDAO;
import br.com.loja.virtual.jdbc.factory.ConnectionFactory;
import br.com.loja.virtual.jdbc.modelo.Categoria;
import br.com.loja.virtual.jdbc.modelo.Produto;

public class TestaListagemDeCategorias {
	public static void main(String[] args) throws SQLException {
		
		try(Connection connection = new ConnectionFactory().conectaDatabase()){
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaDeCategorias = categoriaDAO.listarCategoriasComProdutos();
			listaDeCategorias.stream().forEach(ct -> {
				System.out.println(ct.getNome());
				for(Produto produto : ct.getProdutos()) {
					System.out.println(ct.getNome() + " - " + produto.getNome());
				}
			});
		}
	}
}
