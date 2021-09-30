package entities;

import java.util.ArrayList;
import java.util.List;

import modelo.Venda;

public class ControleVenda {
	
	private static int nVenda=0;
	private static int aux=0;
	
	public static List <Venda> listaVenda = new ArrayList<Venda>();
	
	//Lista sem repetições
	public static void adicionar(Venda c) {
		aux=0;
		for (Venda x: listaVenda) {
			if (x.equals(c)) {
				System.out.println("Venda já adicionado");
				
				aux++;
			}
		} 
		if(aux==0){
			listaVenda.add(c);
			System.out.println("venda adicionada");
			nVenda++;
		}
	}
	public void editar(int pos, Venda c) {
		listaVenda.remove(pos);
		listaVenda.add(pos, c);
		System.out.println("venda alterada! ");
	}
	public void excluir(int i) {
		listaVenda.remove(i);
		nVenda--;
	}
	
	//alterar exibir 
	
	public static void exibir() {
		for (Venda x: listaVenda) {
			System.out.println(x.getCliente());
		}
	}
}
