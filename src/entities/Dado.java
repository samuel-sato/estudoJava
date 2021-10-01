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
			//System.out.println(x.getNome());
		}
		return nome;
	}
	
	public static List<String> nomeProduto (List<Produto> lt) {
		List<String> nome1 = new ArrayList<String>();
		
		for (Produto x: ControleProduto.lista) {
			nome1.add(x.getNome()+" - "+x.getMarca());
			//System.out.println(x.getNome());
		}
		return nome1;
	}
	public static List<String> nomeEstoque (){
		List<String> nome2 = new ArrayList<String>();
		for(int i=0; i<Estoque.posicao; i++) {
			nome2.add(Estoque.produto[i].getNome()+ " - "+ Estoque.quantidade[i]);
		}
		return nome2;
	}
	
}
