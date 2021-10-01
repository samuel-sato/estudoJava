package entities;

import modelo.Produto;


public class Estoque {
	
	public static int[] quantidade = new int[40];
	public static Produto[] produto = new Produto[40];
	public static int posicao=0; 
	
	
	//Adiciona apenas uma unidade ao estoque
	public static void adicionar(Produto p) {
		int aux=0;
		
		if(posicao==0) {
			Estoque.quantidade[posicao]=1;
			Estoque.produto[posicao]=p;
			posicao++;
			
		}else {
			
			for (int i=0; i<posicao; i++) {
				
				if(Estoque.produto[i].equals(p)) {
					
					Estoque.quantidade[i]++;
					
					System.out.println("PRODUTOS IGUAIS");
					aux++;
					break;
				}
			}
			
			if (aux==0) {
				Estoque.produto[posicao]=p;
				Estoque.quantidade[posicao]++;
				posicao++;
			}
		}
	}
	
	
	public static void adicionarVariasUnidades(Produto p, int quantid) {
		int aux=0;
		if(posicao==0) {
			Estoque.quantidade[posicao]+=quantid;
			Estoque.produto[posicao]=p;
			posicao++;
		}else {
			for (int i=0; i<posicao; i++) {
				if(Estoque.produto[i].equals(p)) {
					Estoque.quantidade[i]+=quantid;
					aux++;
				} 
			}
			if (aux==0) {
				Estoque.produto[posicao]=p;
				Estoque.quantidade[posicao]=quantid;
				posicao++;
			}
		}
	}
	public static void retirar(Produto p, int quantidade) {
	
		for (int i=0; i<posicao; i++) {
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
	public static void listarEstoque() {
		if (posicao!=0) {
			for (int i=0; i<posicao; i++) {
				System.out.println("Produto: "+produto[i].getNome()+", Quantidade: "+Estoque.quantidade[i]);
			}
		}else {
			System.out.println("Estoque vazio!!!");
		}
		
	}
	public Estoque() {
		super();
	}
}
