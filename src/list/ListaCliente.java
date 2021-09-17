package list;

import entities.Cliente;

public class ListaCliente {

	private Cliente[] listaCliente = new Cliente[40];
	int posicao = 0;
	
	public void adicionarLista(Cliente v) {
		listaCliente[posicao] = v;
	}
	public void listarClientes() {
		if(posicao!=0) {
			for(int i=0; i<posicao; i++) {
				System.out.println(i+" - " + listaCliente[i]);
			}
		}
	}
	
}
