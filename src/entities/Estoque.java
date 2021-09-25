package entities;

import modelo.Produto;


public class Estoque {
	private static int[] quantidade = new int[40];
	public static Produto[] produto = new Produto[40];
	private int posicao=0; 
	
	
	
	//Adiciona apenas uma unidade ao estoque
	public void adicionar(Produto p) {
		int aux=0;
		
		if(this.posicao==0) {
			Estoque.quantidade[this.posicao]=1;
			Estoque.produto[this.posicao]=p;
			this.posicao++;
			
		}else {
			
			for (int i=0; i<this.posicao; i++) {
				
				if(Estoque.produto[i].equals(p)) {
					
					Estoque.quantidade[i]++;
					
					System.out.println("PRODUTOS IGUAIS");
					aux++;
					break;
				}
			}
			
			if (aux==0) {
				Estoque.produto[this.posicao]=p;
				Estoque.quantidade[this.posicao]++;
				this.posicao++;
			}
		}
	}
	
	
	public void adicionarVariasUnidades(Produto p, int quantid) {
		int aux=0;
		if(this.posicao==0) {
			Estoque.quantidade[this.posicao]+=quantid;
			Estoque.produto[this.posicao]=p;
			this.posicao++;
		}else {
			for (int i=0; i<this.posicao; i++) {
				if(Estoque.produto[i].equals(p)) {
					Estoque.quantidade[i]+=quantid;
					aux++;
				} 
			}
			if (aux==0) {
				Estoque.produto[this.posicao]=p;
				Estoque.quantidade[this.posicao]=quantid;
				this.posicao++;
			}
		}
	}
	public void retirar(Produto p, int quantidade) {
	
		for (int i=0; i<this.posicao; i++) {
			if (Estoque.produto[i].equals(p)) {
				if(Estoque.quantidade[i]>=quantidade) {
					Estoque.quantidade[i]-=quantidade;
					System.out.println("Produto retirado");
	
				} else if(Estoque.quantidade[i]==0) {
					System.out.println("Não tem o produto no estoque");
				} else {
					System.out.println("Não tem tantos produtos em estoque");
				}				
			} else {
				System.out.println("Não tem esse produto");
			}
		}
		
	}
	public void listarEstoque() {
		if (this.posicao!=0) {
			for (int i=0; i<this.posicao; i++) {
				System.out.println("Produto: "+this.produto[i].getNome()+", Quantidade: "+Estoque.quantidade[i]);
			}
		}else {
			System.out.println("Estoque vazio!!!");
		}
		
	}
	public Estoque() {
		super();
	}
}
