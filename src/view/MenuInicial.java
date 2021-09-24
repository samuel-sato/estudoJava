package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import modelo.Perfume;
import entities.Estoque;
//import controle.*;


public class MenuInicial implements ActionListener{
	
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
		
		
		frame.setVisible(true);
	}
	public void teste() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setLayout(null);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(230, 40, 150, 30);
		
		venda.setBounds(140, 100, 100, 30);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		MenuInicial menu = new MenuInicial();
		
		venda.addActionListener(menu);
		cliente.addActionListener(menu);
		produto.addActionListener(menu);
		catalogo.addActionListener(menu);
		relatorio.addActionListener(menu);
		estoque.addActionListener(menu);
		
		Perfume p1 = new Perfume("NOME", "MARCA", 99.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p2 = new Perfume("NOME", "MARCA", 99.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p3 = new Perfume("NOME2", "MARCA2", 199.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p4 = new Perfume("NOME2", "MARCA2", 199.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		
		Estoque e = new Estoque();
		e.adicionar(p1);
		//e.adicionar(p2);
		e.adicionar(p3);
		//e.adicionar(p4);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cliente) {
			System.out.println("AAAAAAAAAAAA");
		}
		if(src == produto) {
			new TelaProduto();
			System.out.println("bbbbbb");
		}
			
		
			
		
	}
}
