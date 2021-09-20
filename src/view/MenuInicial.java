package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import controle.*;


public class MenuInicial{
	
	private static JFrame frame = new JFrame("Loja de Perfume");
	private static JLabel titulo = new JLabel("Menu Inicial");
	private static JButton venda = new JButton("Venda");
	private static JButton cliente = new JButton("Cliente");
	private static JButton produto = new JButton("Produto");
	private static JButton catalogo = new JButton("Catalogo");
	private static JButton relatorio = new JButton("Relatório");
	private static JButton estoque = new JButton("Estoque");

	public MenuInicial() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setLayout(null);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(230, 40, 150, 30);
		
		venda.setBounds(140, 100, 100, 30);
		cliente.setBounds(250, 100, 100, 30);
		produto.setBounds(360, 100, 100, 30);
		
		catalogo.setBounds(140, 160, 100, 30);
		relatorio.setBounds(250, 160, 100, 30);
		estoque.setBounds(360, 160, 100, 30);
		
		frame.add(titulo);
		frame.add(venda);
		frame.add(cliente);
		frame.add(produto);
		frame.add(catalogo);
		frame.add(relatorio);
		frame.add(estoque);
		
		venda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Botão foi acionado!");
			}
		});
		
		frame.setVisible(true);
	}
}
