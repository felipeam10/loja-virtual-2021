package br.com.loja.virtual.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.loja.virtual.jdbc.dao.ProdutoDAO;
import br.com.loja.virtual.jdbc.factory.ConnectionFactory;
import br.com.loja.virtual.jdbc.modelo.Produto;

public class TestaInsercaoEListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto guardaRoupa = new Produto("Guarda Roupas", "06 portas");
		
		try (Connection connection = new ConnectionFactory().conectaDatabase()) {
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(guardaRoupa);
			List<Produto> listaDeProdutos = produtoDAO.listar();
			listaDeProdutos.stream().forEach(listaProd -> System.out.println(listaProd));
			
		}
	}
}