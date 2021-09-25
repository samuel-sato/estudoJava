package entities;

import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;
import modelo.Produto;

public class Dado {

	public static List<String> nomeCliente (List<Cliente> lt) {
		List<String> nome = new ArrayList<String>();
		
		for (Cliente x: ControleCliente.listaCliente) {
			nome.add(x.getNome());
			System.out.println(x.getNome());
		}
		return nome;
	}
	
	public static List<String> nomeProduto (List<Produto> lt) {
		List<String> nome = new ArrayList<String>();
		
		for (Cliente x: ControleCliente.listaCliente) {
			nome.add(x.getNome());
			System.out.println(x.getNome());
		}
		return nome;
	}
	
}
