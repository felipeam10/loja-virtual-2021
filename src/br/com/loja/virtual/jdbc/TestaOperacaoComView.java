package br.com.loja.virtual.jdbc;

import java.sql.SQLException;

import javax.swing.JFrame;

import br.com.loja.virtual.jdbc.view.ProdutoCategoriaFrame;

public class TestaOperacaoComView {
	public static void main(String[] args) throws SQLException {
		ProdutoCategoriaFrame produtoCategoriaFrame = new ProdutoCategoriaFrame();
		produtoCategoriaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
