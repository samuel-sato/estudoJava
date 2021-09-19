package entities;

import modelo.Produto;


public final class Estoque {
	private int[] quantidade = new int[40];
	private Produto[] produto = new Produto[40];
	private int posicao=0; 
	
	//Adiciona apenas uma unidade ao estoque
	public void adicionar(Produto p) {
		int aux=0;
		
		if(this.posicao==0) {
			this.quantidade[this.posicao]=1;
			this.produto[this.posicao]=p;
			this.posicao++;
			
		}else {
			
			for (int i=0; i<=this.posicao; i++) {
				
				if(this.produto[i].equals(p)) {
					
					this.quantidade[i]++;
					
					System.out.println("PRODUTOS IGUAIS");
					aux++;
					break;
				}
			}
			
			if (aux==0) {
				this.produto[this.posicao]=p;
				this.quantidade[this.posicao]++;
				this.posicao++;
			}
		}
	}
	
	
	public void adicionarVariasUnidades(Produto p, int quantid) {
		int aux=0;
		if(this.posicao==0) {
			this.quantidade[this.posicao]+=quantid;
			this.produto[this.posicao]=p;
			this.posicao++;
		}else {
			for (int i=0; i<this.posicao; i++) {
				if(this.produto[i].equals(p)) {
					this.quantidade[i]+=quantid;
					aux++;
				} 
			}
			if (aux==0) {
				this.produto[this.posicao]=p;
				this.quantidade[this.posicao]=quantid;
				this.posicao++;
			}
		}
	}
	public void retirar(Produto p, int quantidade) {
	
		for (int i=0; i<this.posicao; i++) {
			if (this.produto[i].equals(p)) {
				if(this.quantidade[i]>=quantidade) {
					this.quantidade[i]-=quantidade;
					System.out.println("Produto retirado");
	
				} else if(this.quantidade[i]==0) {
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
				System.out.println("Produto: "+this.produto[i].getNome()+", Quantidade: "+this.quantidade[i]);
			}
		}else {
			System.out.println("Estoque vazio!!!");
		}
		
	}
	public Estoque() {
		super();
	}
}
