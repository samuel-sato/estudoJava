package entities;

import java.util.ArrayList;
import java.util.List;

import modelo.Venda;

public class ControleVenda {
	
	private int nVenda=0;
	private int aux=0;
	
	List <Venda> listaVenda = new ArrayList<Venda>();
	
	//Lista sem repetições
	public void adicionar(Venda c) {
		this.aux=0;
		for (Venda x: this.listaVenda) {
			if (x.equals(c)) {
				System.out.println("Cliente já adicionado");
				
				this.aux++;
			}
		} 
		if(this.aux==0){
			listaVenda.add(c);
			System.out.println("cliente adicionado");
			this.nVenda++;
		}
	}
	public void editar(int pos, Venda c) {
		listaVenda.remove(pos);
		listaVenda.add(pos, c);
		System.out.println("cliente alterado! ");
	}
	public void excluir(int i) {
		listaVenda.remove(i);
		this.nVenda--;
	}
	
	//alterar exibir 
	/*
	public void exibir() {
		for (Venda x: this.listaVenda) {
			//System.out.println(x.getNome());
		}
	}*/
}
