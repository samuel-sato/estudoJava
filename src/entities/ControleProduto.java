package entities;

import modelo.Cliente;
import modelo.Produto;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

import javax.swing.DefaultListModel;

public class ControleProduto {
	
	//private static Object[] listaProdutos = new Object[50];
	private static int nProduto=0;
	private static int aux=0;
	
	public static List<Produto> lista = new ArrayList<Produto>();
	//private static DefaultListModel lista = new DefaultListModel();
	public ControleProduto() {
		super();
	}

	//Lista sem repetições
	public static void adicionar(Produto p) {
		//Estoque.adicionar(p);
		aux=0;
		for (Produto x: lista) {
			if (x.equals(p)) {
				System.out.println("Produto já adicionado");
				aux++;
			}
		} 
		if(aux==0){
			lista.add(p);
			System.out.println("produto adicionado");
			Estoque.adicionar(p, 0);
			nProduto++;
		}
	}
	public static void editar(int pos, Produto p) {
		lista.remove(pos);
		lista.add(pos, p);
		System.out.println("Produto alterado! ");
		//Estoque.listarEstoque().
	}
	public static void excluir(int i) {
		lista.remove(i);
		nProduto--;
	}
	
	public static void exibir() {
		for (Produto x: lista) {
			System.out.println(x.getNome());
		}
	}
	public static String buscar(String nome) {
		String resultado = "Não há produtos com esse nome";
		int aux =0;
		for (Produto x: lista) {
			if(x.getNome().equalsIgnoreCase(nome)) {
				resultado = x.toString();
				aux++; 
			}
		}
		if (aux != 0) {
			return resultado;
		}else {
			return resultado;
		}
		
	}
	public static void listar() {
		for (Produto p:lista) {
			System.out.println(p.getNome());
		}
	}
	public int getnProduto() {
		return nProduto;
	}
	
}
