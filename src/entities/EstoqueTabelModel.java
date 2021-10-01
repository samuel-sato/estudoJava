package entities;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import modelo.Produto;
/*
public class EstoqueTabelModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;

	public static final int INDEX_NOME = 0;
	public static final int INDEX_PRECO = 1;
	public static final int INDEX_QUANTIDADE = 2;
	public static final int INDEX_ESCONDIDO = 3;
	
	protected String[] nomeColunas = {"Nome", "Preço", "Quantidade"};
	
	protected Vector<Produto> vetorProdutos;
	
	public EstoqueTabelModel() {
		vetorProdutos = new Vector<Produto>();
	}
	public String getNomeColuna(int coluna) {
		return nomeColunas[coluna];
	}
	public boolean isCellEditable(int linha, int coluna) {
		if (coluna == INDEX_ESCONDIDO) {
			return false;
		} else {
			return true;
		}
	}
	public Object getValueAt(int linha, int coluna) {
		Produto produto = (Produto) vetorProdutos.get(linha);
		switch (coluna) {
		case INDEX_NOME:
			return produto.getNome();
		case INDEX_PRECO:
			return produto.getPreco();
		case INDEX_FONE:
			return produto.get();
		default:
			return new Object();
		}
	}
	
}
*/