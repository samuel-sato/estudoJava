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
		Creme p5 = new Creme("creme", "marcacreme", 15.98, "descricao", "pele", "rosto", 500);
		Sabonete p6 = new Sabonete("SANONETE", "Dove", 15.90, "descrição sabonete", "mão",250, "cheiro");
		


		Estoque e = new Estoque();
		e.adicionar(p1);
		
		e.adicionar(p3);
		
		Cliente c1 = new Cliente("sato1", "123456789", "sam@gmail.com", "098755241", "1245213425");
		Cliente c2 = new Cliente("sato2", "123456789", "sam@gmail.com", "098742111", "1245213425");
		Cliente c3 = new Cliente("sato3", "123456789", "sam@gmail.com", "0987500001", "1245213425");
		Cliente c4 = new Cliente("sato4", "123456789", "sam@gmail.com", "3123", "1245213425");
		Cliente c5 = new Cliente("sato5", "123456789", "sam@gmail.com", "098412157500001", "1245213425");
		Cliente c6 = new Cliente("sato6", "123456789", "sam@gmail.com", "8765421", "1245213425");
		Cliente c7 = new Cliente("sato7", "123456789", "sam@gmail.com", "52626", "1245213425");
		Cliente c8 = new Cliente("sato8", "123456789", "sam@gmail.com", "235235", "1245213425");
		Cliente c9 = new Cliente("sato9", "123456789", "sam@gmail.com", "84584", "1245213425");
		Cliente c0 = new Cliente("sato0", "123456789", "sam@gmail.com", "7457457", "1245213425");
		
		//ControleCliente controle = new ControleCliente();
		
		ControleCliente.adicionar(c1);
		ControleCliente.adicionar(c2);
		ControleCliente.adicionar(c3);
		ControleCliente.adicionar(c4);
		ControleCliente.adicionar(c5);
		ControleCliente.adicionar(c6);
		ControleCliente.adicionar(c7);
		ControleCliente.adicionar(c8);
		ControleCliente.adicionar(c9);
		ControleCliente.adicionar(c0);
		
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
	}
}
//https://sig.unb.br/sigaa/link/public/extensao/visualizacaoAcaoExtensao/3087
