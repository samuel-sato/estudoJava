package entities;


import modelo.Produto;

import java.util.ArrayList;
import java.util.List;


public class DadoProduto {
	
	private static int nProduto=0;
	private static int aux=0;
	
	private static List<Produto> lista = new ArrayList<Produto>();
	
	public DadoProduto() {
		super();
	}
	public static Produto getProduto(int i) {
		return lista.get(i);
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
			//System.out.println("produto adicionado");
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
	
	public static List<String> nomeProduto () {
		List<String> nome1 = new ArrayList<String>();
		
		for (Produto x: DadoProduto.lista) {
			nome1.add(x.getNome()+" - "+x.getMarca());
			//System.out.println(x.getNome());
		}
		return nome1;
	}
	
}
