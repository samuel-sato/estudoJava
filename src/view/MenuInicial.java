package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import entities.DadoCliente;
import entities.DadoProduto;
import entities.DadoVenda;
import entities.Estoque;
import modelo.Cliente;
import modelo.Creme;
import modelo.Perfume;
import modelo.Sabonete;
import modelo.Venda;


public class MenuInicial implements ActionListener{
	
	private static JFrame frame = new JFrame("Loja de Perfume");
	private static JLabel titulo = new JLabel("Menu Inicial");
	private static JButton venda = new JButton("Venda");
	private static JButton cliente = new JButton("Cliente");
	private static JButton produto = new JButton("Produto");
	//private static JButton catalogo = new JButton("Catalogo");
	private static JButton relatorio = new JButton("Relatório");
	private static JButton busca = new JButton("Busca");
	private static JButton estoque = new JButton("Estoque");

	public MenuInicial() {
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 300);
		frame.setLayout(null);
		
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(230, 40, 150, 30);
		
		venda.setBounds(200, 100, 100, 30);
		cliente.setBounds(310, 100, 100, 30);
		produto.setBounds(200, 150, 100, 30);
		
		estoque.setBounds(310, 150, 100, 30);
		busca.setBounds(310, 200, 100, 30);
		relatorio.setBounds(200, 200, 100, 30);
		
		frame.add(titulo);
		frame.add(venda);
		frame.add(cliente);
		frame.add(produto);
		frame.add(busca);
		frame.add(relatorio);
	
		frame.add(estoque);
		
		
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		MenuInicial menu = new MenuInicial();
		
		venda.addActionListener(menu);
		cliente.addActionListener(menu);
		produto.addActionListener(menu);
		//catalogo.addActionListener(menu);
		relatorio.addActionListener(menu);
		busca.addActionListener(menu);
		estoque.addActionListener(menu);
		
		Perfume p1 = new Perfume("Perfume1", "MARCA", 99.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p2 = new Perfume("Perfume2", "MARCA", 99.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p3 = new Perfume("Perfume3", "MARCA2", 199.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p4 = new Perfume("Perfume4", "MARCA2", 199.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Creme p5 = new Creme("Creme1", "marcacreme", 15.98, "descricao creme1", "pele", "rosto", 500);
		Creme p6 = new Creme("Creme2", "marcacreme", 15.98, "descricao creme2", "pele", "rosto", 500);
		Creme p7 = new Creme("Creme3", "marcacreme", 15.98, "descricao creme3", "pele", "rosto", 500);
		Creme p8 = new Creme("Creme4", "marcacreme", 15.98, "descricao creme4", "pele", "rosto", 500);
		Sabonete p9 = new Sabonete("Sabonete1", "Dove", 15.90, "descrição sabonete1", "mão",250, "cheiro");
		Sabonete p10 = new Sabonete("Sabonete2", "Dove", 15.90, "descrição sabonete2", "mão",250, "cheiro");
		Sabonete p11 = new Sabonete("Sabonete3", "Dove", 15.90, "descrição sabonete3", "mão",250, "cheiro");
		Sabonete p12 = new Sabonete("Sabonete4", "Dove", 15.90, "descrição sabonete4", "mão",250, "cheiro");
		
		Estoque.adicionar(p1,5);
		Estoque.adicionar(p2,5);
		Estoque.adicionar(p3,5);
		Estoque.adicionar(p4,5);
		Estoque.adicionar(p5,5);
		Estoque.adicionar(p6,5);
		Estoque.adicionar(p7,5);
		Estoque.adicionar(p8,5);
		Estoque.adicionar(p9,5);
		Estoque.adicionar(p10,5);
		Estoque.adicionar(p11,5);
		Estoque.adicionar(p12,5);
		
		DadoProduto.adicionar(p1);
		DadoProduto.adicionar(p2);
		DadoProduto.adicionar(p3);
		DadoProduto.adicionar(p4);
		DadoProduto.adicionar(p5);
		DadoProduto.adicionar(p6);
		DadoProduto.adicionar(p7);
		DadoProduto.adicionar(p8);
		DadoProduto.adicionar(p9);
		DadoProduto.adicionar(p10);
		DadoProduto.adicionar(p11);
		DadoProduto.adicionar(p12);
		
		Cliente c0 = new Cliente("ANONIMO", "OOOOO", "ANONIMO", "0000000", "000000");
		Cliente c1 = new Cliente("Ana", "12345678", "ana@gmail.com", "098755241", "1245213425");
		Cliente c2 = new Cliente("Fernanda", "98765432", "fer@gmail.com", "098755241", "1245213425");
		Cliente c3 = new Cliente("Davi", "12312312", "davi@gmail.com", "0987500001", "1245213425");
		Cliente c4 = new Cliente("Marcos", "32132132", "marcos@gmail.com", "3123", "1245213425");
		Cliente c5 = new Cliente("Daniela", "01010101", "dani@gmail.com", "098412157500001", "1245213425");
		Cliente c6 = new Cliente("Alex", "13123146", "alex@gmail.com", "8765421", "1245213425");
		
		DadoCliente.adicionar(c0);
		DadoCliente.adicionar(c1);
		DadoCliente.adicionar(c2);
		DadoCliente.adicionar(c3);
		DadoCliente.adicionar(c4);
		DadoCliente.adicionar(c5);
		DadoCliente.adicionar(c6);

		Venda v1 = new Venda(c1, p1, 1, "Dinheiro");
		v1.adicionarCarrinho(p11, 2);
		v1.vender();
		Venda v2 = new Venda(c2, p5, 3, "Cartão");
		v2.setDataFormatada("21/04/2021");
		v2.vender();
		Venda v3 = new Venda(c3, p6, 2, "Pix");
		v3.setDataFormatada("22/04/2020");
		v3.vender();
		Venda v4 = new Venda(c4, p12, 4, "Dinheiro");
		v4.vender();
		
		DadoVenda.adicionar(v1);
		DadoVenda.adicionar(v2);
		DadoVenda.adicionar(v3);
		DadoVenda.adicionar(v4);
		//System.out.println(v1.getListaVenda().toString());
		//System.out.println(v2.getListaVenda().toString());
		//System.out.println(v3.getListaVenda().toString());
		//System.out.println(v4.getListaVenda().toString());
		
		
		//System.out.println();
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
		if(src == busca) {
			new TelaBusca();
		}
		if(src == relatorio) {
			new TelaRelatorio();
		}
	}
}