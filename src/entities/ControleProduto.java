package entities;

import modelo.Produto;

import java.util.ArrayList;
import java.util.List;
//import java.util.stream.Collectors;

public class ControleProduto {
	//private Produto[] listaProdutos = new Produto[50];
	private int nProduto=0;
	private int aux=0;
	
	public ControleProduto() {
		super();
	}
	//usando lista
	List<Produto> lista = new ArrayList<Produto>();
	
	//Lista sem repetições
	public void adicionar(Produto p) {
		this.aux=0;
		for (Produto x: this.lista) {
			if (x.equals(p)) {
				System.out.println("Produto já adicionado");
				
				this.aux++;
			}
		} 
		if(this.aux==0){
			lista.add(p);
			System.out.println("produto adicionado");
			this.nProduto++;
		}
	}
	public void editar(int pos, Produto p) {
		lista.remove(pos);
		lista.add(pos, p);
		System.out.println("Produto alterado! ");
	}
	public void excluir(int i) {
		lista.remove(i);
		this.nProduto--;
	}
	
	public void exibir() {
		for (Produto x: this.lista) {
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
