package entities;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;

import modelo.Cliente;


public class ControleCliente {
	//private Cliente[] c;
	private static int nCliente;
	private static int aux=0;

	public static List <Cliente> listaCliente = new ArrayList<Cliente>();
		
	//Lista sem repetições
	public static void adicionar(Cliente c) {
		ControleCliente.aux=0;
		for (Cliente x: ControleCliente.listaCliente) {
			if (x.equals(c)) {
				System.out.println("Cliente já adicionado");
				
				ControleCliente.aux++;
			}
		} 
		if(ControleCliente.aux==0){
			listaCliente.add(c);
			
			System.out.println("cliente adicionado");
			nCliente++;
		}
	}
	public static void editar(int pos, Cliente c) {
		listaCliente.remove(pos);
		
		listaCliente.add(pos, c);
		
		System.out.println("cliente alterado! ");
	}
	public static void excluir(int i) {
		listaCliente.remove(i);
		
		nCliente--;
	}
	
	//alterar exibir 
	public static void exibir() {
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
