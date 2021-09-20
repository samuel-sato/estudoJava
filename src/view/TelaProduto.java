package view;


import javax.swing.*;
public class TelaProduto {

	private static JFrame frame = new JFrame("Produto");
	private static JLabel titulo = new JLabel("Lista de Produtos");
	private static JButton cadastrar = new JButton("Cadastrar");
	
	public TelaProduto() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setLayout(null);
		
		titulo.setBounds(100, 10, 150, 30);
		
		frame.add(titulo);
		frame.setVisible(true);
	}
}
