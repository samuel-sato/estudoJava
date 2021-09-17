package list;

import entities.Venda; 

public class ListaVenda {

	private Venda[] listaVenda = new Venda[40];
	private int posicao=0;
	
	public void adicionarLista(Venda v) {
		listaVenda[posicao] = v;
	}
	public void listarVendas() {
		if(posicao!=0) {
			for(int i=0; i<posicao; i++) {
				System.out.println(i+" - " + listaVenda[i]);
			}
		}
	}
	
}
