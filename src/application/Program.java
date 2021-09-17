package application;
import product.Perfume;
import entities.Venda;

import javax.swing.*;

import entities.Estoque;


public class Program {
	public static void main(String[] args) {
		
		System.out.println("Tá rodando! ");
		
		Perfume p1 = new Perfume("NOME", "MARCA", 99.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p2 = new Perfume("NOME", "MARCA", 99.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p3 = new Perfume("NOME2", "MARCA2", 199.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		Perfume p4 = new Perfume("NOME2", "MARCA2", 199.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
		
		Estoque e1 = new Estoque();
		Venda v1 = new Venda();
		
		//Venda v1 = new Venda(p1, "Dinheiro", LocalDateTime.now(), e1);
		
		
		System.out.println("NOME: "+p1.getNome());
		//System.out.println(v1.toString());
		e1.adicionar(p1);
		e1.listarEstoque();
		System.out.println();
		e1.adicionar(p2);
		e1.listarEstoque();
		System.out.println();
		e1.adicionarVariasUnidades(p3, 3);
		e1.listarEstoque();
		System.out.println();
		e1.adicionar(p4);
		e1.listarEstoque();
		System.out.println();
		e1.retirar(p1, 1);
		e1.retirar(p2, 1);
		e1.retirar(p2, 1);
		System.out.println();
		e1.listarEstoque();
		v1.adicionarCarrinho(p1, 2);
		v1.vender("CARTÃO", e1);
		//v1.vender("CARTÃO", e1);
		System.out.println();
		e1.listarEstoque();
		System.out.println();
		v1.listaProdutos();
		

		JFrame frame = new JFrame("SISTEMA LOJA");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 400);
		frame.setLayout(null);
		
		
		JLabel label = new JLabel("Fala meu Peixe. Escolha uma opção", JLabel.CENTER);
		label.setBounds(20, 30, 360, 40);
		
		frame.add(label);
		frame.setVisible(true);
		
		
		
	}
}
