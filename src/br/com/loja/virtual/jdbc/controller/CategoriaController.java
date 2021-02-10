package br.com.loja.virtual.jdbc.controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.loja.virtual.jdbc.factory.ConnectionFactory;
import br.com.loja.virtual.jdbc.modelo.Categoria;
import br.com.loja.virtual.jdbc.dao.CategoriaDAO;

public class CategoriaController {
	
	private CategoriaDAO categoriaDAO;

	public CategoriaController() {
		Connection connection = new ConnectionFactory().conectaDatabase();
		this.categoriaDAO = new CategoriaDAO(connection);
	}


	public List<Categoria> listar() {
		return this.categoriaDAO.listar();
	}
}
