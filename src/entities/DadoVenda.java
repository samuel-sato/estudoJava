package entities;

import java.util.ArrayList;
import java.util.List;

import modelo.Venda;

public class DadoVenda {
	
	private static int nVenda=0;
	private static int aux=0;
	
	private static List <Venda> listaVenda = new ArrayList<Venda>();
	private static List <String> listaData = new ArrayList<>();
	
	public static List<String> getListaRelatorio() {
		List<String> relatorio = new ArrayList<>();
		for (Venda x: listaVenda) {
			relatorio.add(x.getCliente().getNome() + " - "+ x.getData());
		}
		return relatorio;
	}
	public static List<String> getListaData() {
		return listaData;
	}
	
	//Lista sem repetições
	public static void adicionar(Venda v) {
		aux=0;
		int i=0;
		for (Venda x: listaVenda) {
			if (x.equals(v)) {
				System.out.println("Venda já adicionado");
				aux++;
			}
			if(x.getDataFormatada().equalsIgnoreCase(v.getDataFormatada())) {
				i++;
			}
		} 
		if(aux==0){
			listaVenda.add(v);
			System.out.println("venda adicionada");
			nVenda++;
		}
		if(i==0) {
			listaData.add(v.getDataFormatada());
		}
	}
	public void editar(int pos, Venda v) {
		listaVenda.remove(pos);
		listaVenda.add(pos, v);
		System.out.println("venda alterada! ");
	}
	public void excluir(int i) {
		listaVenda.remove(i);
		nVenda--;
	}
	
	public static List<String> buscarPorData(String data) {
		List<String> listaBusca = new ArrayList<>();
		for (Venda x: listaVenda) {
			if(x.getDataFormatada().equalsIgnoreCase(data)) {
				listaBusca.add(x.getCliente().getNome() + " - "+ x.getData());
			}
		}
		return listaBusca;
	}
	
	//alterar exibir 
	
	public static void exibir() {
		for (Venda x: listaVenda) {
			System.out.println(x.getCliente()+" - "+x.getFormaPagamento());
		}
	}
}
