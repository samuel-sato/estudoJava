package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import modelo.Cliente;
import modelo.Creme;
import modelo.Perfume;
import modelo.Sabonete;
import entities.ControleCliente;
import entities.ControleProduto;
import entities.Estoque;


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
		
		venda.setBounds(200, 100, 100, 30);
		cliente.setBounds(310, 100, 100, 30);
		produto.setBounds(200, 160, 100, 30);
		
		//catalogo.setBounds(140, 160, 100, 30);
		//relatorio.setBounds(250, 160, 100, 30);
		estoque.setBounds(310, 160, 100, 30);
		
		frame.add(titulo);
		frame.add(venda);
		frame.add(cliente);
		frame.add(produto);
		//frame.add(catalogo);
		//frame.add(relatorio);
		frame.add(estoque);
		
		
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
		
		Perfume p1 = new Perfume("Perfume1", "MARCA", 99.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p2 = new Perfume("Perfume2", "MARCA", 99.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p3 = new Perfume("Perfume3", "MARCA2", 199.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p4 = new Perfume("Perfume4", "MARCA2", 199.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Creme p5 = new Creme("Creme1", "marcacreme", 15.98, "descricao", "pele", "rosto", 500);
		Sabonete p6 = new Sabonete("Sabonete1", "Dove", 15.90, "descrição sabonete", "mão",250, "cheiro");
		
		Estoque.adicionar(p1);
		Estoque.adicionar(p2);
		Estoque.adicionar(p3);
		Estoque.adicionar(p4);
		Estoque.adicionar(p5);
		
		Cliente c1 = new Cliente("Ana", "12345678", "ana@gmail.com", "098755241", "1245213425");
		Cliente c2 = new Cliente("Fernanda", "98765432", "fer@gmail.com", "098755241", "1245213425");
		Cliente c3 = new Cliente("Davi", "12312312", "davi@gmail.com", "0987500001", "1245213425");
		Cliente c4 = new Cliente("Marcos", "32132132", "marcos@gmail.com", "3123", "1245213425");
		Cliente c5 = new Cliente("Daniela", "01010101", "dani@gmail.com", "098412157500001", "1245213425");
		Cliente c6 = new Cliente("Alex", "13123146", "alex@gmail.com", "8765421", "1245213425");
		
		
		ControleCliente.adicionar(c1);
		ControleCliente.adicionar(c2);
		ControleCliente.adicionar(c3);
		ControleCliente.adicionar(c4);
		ControleCliente.adicionar(c5);
		ControleCliente.adicionar(c6);

		ControleProduto.adicionar(p1);
		ControleProduto.adicionar(p2);
		ControleProduto.adicionar(p3);
		ControleProduto.adicionar(p4);
		ControleProduto.adicionar(p5);
		ControleProduto.adicionar(p6);
		
		System.out.println();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == venda) {
			new TelaVenda();
		}
		if(src == cliente) {
			new TelaCliente();
		}
		if(src == produto) {
			new TelaProduto();
		}
		if(src == estoque) {
			new TelaEstoque();
		}
	}
}