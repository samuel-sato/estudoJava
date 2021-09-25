package view;

//import modelo.Produto;
import javax.swing.*;

import entities.Estoque;

public class TelaProduto {

	private static JFrame frame = new JFrame("Produto");
	private static JLabel titulo = new JLabel("Lista de Produtos");
	private static JButton cadastrar = new JButton("Cadastrar");
	
	//private static Produto[] listaProduto = new Produto[50];
	private static JList lista = new JList(Estoque.produto);
	
	public TelaProduto() {
		
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setLayout(null);
		
		titulo.setBounds(100, 10, 150, 30);
		
		lista.setBounds(100, 80, 150, 100);
		
		frame.add(lista);
		frame.add(titulo);
		frame.setVisible(true);
	}
}
