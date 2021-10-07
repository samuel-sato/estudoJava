package entities;

import java.util.ArrayList;
import java.util.List;

import modelo.Creme;
import modelo.Kit;
import modelo.Perfume;
import modelo.Produto;
import modelo.Sabonete;


public class Estoque {
	
	private static int[] quantidade = new int[40];
	private static Produto[] produto = new Produto[40];
	private static int posicao=0;
	
	public Estoque() {
		super();
	}
		
	public static int[] getQuantidade() {
		return quantidade;
	}
	
	public static Produto[] getProduto() {
		return produto;
	}

	public static int getPosicao() {
		return posicao;
	}

	public static void editarProduto(int id, Produto p) {

		for (int i=0; i<posicao; i++) {
			if(produto[i].getID() == id) {
				produto[i] = p;
			}
		}
		listarEstoque();
		
	}
	
	public static void adicionar(Produto p, int quantid) {
		int aux=0;
		if(posicao==0) {
			Estoque.quantidade[posicao]+=quantid;
			Estoque.produto[posicao]=p;
			posicao++;
		}else {
			for (int i=0; i<posicao; i++) {
				try {
					if(Estoque.produto[i].equals(p)) {
						Estoque.quantidade[i]+=quantid;
						aux++;
					}
				}catch(NullPointerException ex) {
					
				}
				 
			}
			if (aux==0) {
				Estoque.produto[posicao]=p;
				Estoque.quantidade[posicao]=quantid;
				posicao++;
			}
		}
		/*
		for (int i=0; i<posicao; i++) {
			try {
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
			} catch (NullPointerException ex) {
				
			}
			
		}
		*/
	}
	public static void retirar(Produto p, int quantidade) {
	
		for (int i=0; i<posicao; i++) {
			try {
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
			} catch (NullPointerException ex) {
				
			}
			
		}
	}
	public static void excluir(int id) {
		for (int i=0; i<posicao; i++) {
			try {
				if (produto[i].getID()==id) {
					produto[i]=null;
					//posicao--;
				}
			} catch(NullPointerException ex) {
				
			}
			
		}
	}
	//retorna lista
	public static List<String> listarEstoque() {
		List<String> listaEstoque = new ArrayList<>();
		if (posicao!=0) {
			for (int i=0; i<posicao; i++) {
				//System.out.println("Produto: "+produto[i].getNome()+", Quantidade: "+Estoque.quantidade[i]);
				try {
					listaEstoque.add(Estoque.produto[i].getNome() + ", Quantidade: "+Estoque.quantidade[i]);
					System.out.println(Estoque.produto[i].getNome() + ", Quantidade: "+Estoque.quantidade[i]);
				} catch(NullPointerException ex) {
					
				}
			}
		}else {
			System.out.println("Estoque vazio!!!");
		}
		return listaEstoque;
	}
	public static List<String> listaParaVenda(){
		List<String> listaVenda = new ArrayList<>();
		for (int i=0; i<posicao; i++) {
			try {
				if(Estoque.produto[i].getPreco() != 0) {
					listaVenda.add(Estoque.produto[i].getNome());					
				} 
			}catch(NullPointerException ex) {

			}
		}
		return listaVenda; 
	}
	
}
