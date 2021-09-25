package entities;
import java.util.ArrayList;
import java.util.List;

import modelo.Cliente;


public class ControleCliente {
	//private Cliente[] c;
	private int nCliente;
	private int aux=0;
	
	public static List <Cliente> listaCliente = new ArrayList<Cliente>();
		
	//Lista sem repetições
	public void adicionar(Cliente c) {
		this.aux=0;
		for (Cliente x: ControleCliente.listaCliente) {
			if (x.equals(c)) {
				System.out.println("Cliente já adicionado");
				
				this.aux++;
			}
		} 
		if(this.aux==0){
			listaCliente.add(c);
			
			System.out.println("cliente adicionado");
			this.nCliente++;
		}
	}
	public void editar(int pos, Cliente c) {
		listaCliente.remove(pos);
		
		listaCliente.add(pos, c);
		
		System.out.println("cliente alterado! ");
	}
	public void excluir(int i) {
		listaCliente.remove(i);
		
		this.nCliente--;
	}
	
	//alterar exibir 
	public void exibir() {
		for (Cliente x: ControleCliente.listaCliente) {
			System.out.println(x.getNome());
		}
	}
	public int getnCliente() {
		return nCliente;
	}
	public ControleCliente() {
		super();
	}
	
}
