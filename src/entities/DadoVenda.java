package entities;

import java.util.ArrayList;
import java.util.List;

import modelo.Venda;

/**
 * Classe que armazena dados das Vendas
 * @author samuel
 * @version 1.0
 */
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
	public static List<Venda> getListaVenda(){
		return listaVenda;
	}
	
	//Lista sem repetições
	public static boolean adicionar(Venda v) {
		aux=0;
		int i=0;
		for (Venda x: listaVenda) {
			if (x.equals(v)) {
				//System.out.println("Venda já adicionado");
				aux++;
			}
			if(x.getDataFormatada().equalsIgnoreCase(v.getDataFormatada())) {
				i++;
			}
		}
		if(i==0) {
			listaData.add(v.getDataFormatada());
		}
		if(aux==0){
			listaVenda.add(v);
			//System.out.println("venda adicionada");
			nVenda++;
			return true;
		} else {
			return false;
		}
		
	}
	public static void editar(int pos, Venda v) {
		listaVenda.remove(pos);
		listaVenda.add(pos, v);
		System.out.println("venda alterada! ");
	}
	public static boolean excluir(int i) {
		try {
			listaVenda.remove(i);
			nVenda--;
			return true;
		} catch(NullPointerException ex){
			return false;
		}
		
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
	public static Venda buscaPorVenda(int id) {
		Object v = new Object();
		int i=0;
		for (Venda x: listaVenda) {
			if(x.getID() == id) {
				v = x;
				i++;
				//System.out.println(x.getListaVenda());
			}
		}
		if(i==0) {
			return null;
		}else {
			//System.out.println((Venda) v);
			return (Venda) v;
		}
		
	}
	
	//alterar exibir 
	
	public static void exibir() {
		for (Venda x: listaVenda) {
			System.out.println(x.getCliente()+" - "+x.getFormaPagamento());
		}
	}
}
