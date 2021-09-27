package entities;

import modelo.Cliente;
import modelo.Produto;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

public class ControleProduto {
	//private Produto[] listaProdutos = new Produto[50];
	private static int nProduto=0;
	private static int aux=0;
	
	public static List<Produto> lista = new ArrayList<Produto>();
	
	public ControleProduto() {
		super();
	}
	
	
	
	//Lista sem repetições
	public static void adicionar(Produto p) {
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
			nProduto++;
		}
	}
	public void editar(int pos, Produto p) {
		lista.remove(pos);
		lista.add(pos, p);
		System.out.println("Produto alterado! ");
	}
	public void excluir(int i) {
		lista.remove(i);
		nProduto--;
	}
	
	public void exibir() {
		for (Produto x: lista) {
			System.out.println(x.getNome());
		}
	}
	
	
	
	/*
	public void adicionarProduto(Produto p) {
		if (this.nProduto == 0) {
			this.listaProdutos[0] = p;
			p.setID(this.nProduto);
			this.nProduto++;
		} else {
			for (int i=0; i<=this.nProduto;i++) {
				if(this.listaProdutos[i].equals(p)) {
					System.out.println("Produto já adicionado");
					aux++;
				} 
			}
			if(aux==0) {
				this.listaProdutos[this.nProduto] = p;
				p.setID(this.nProduto);
				this.nProduto++;
			}
		}
	}
	
	public void editarProduto(Produto p, int pos) {
		this.listaProdutos[pos] = p;
	}
	
	public void excluirProduto() {
		
	}
	*/

	public int getnProduto() {
		return nProduto;
	}
	
}
