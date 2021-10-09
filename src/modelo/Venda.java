package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Estoque;

/**
 * Classe que modela Venda
 * @author samuel
 * @version 1.0
 */

public class Venda {
	/**
	 * Classe apresenta metodos para manipulação dos dados de uma venda
	 * Classe apresenta dois costrutores:
	 * (1) Usado para fazer venda anonima e adicionar atributos separadamente
	 * (2) Cria uma venda com todos os parametros 
	 * @param Cliente é a pessoa que realiza a compra
	 * @param p é o produto da venda
	 * @param unidade é a quantidade dendida do produto p
	 * @param formapagamento é o meio de pagamento da venda   
	 * 
	 */
	
	
	private int ID;
	private Cliente cliente;
	private List<Produto> carrinho = new ArrayList<>();
	private List<Integer> unid = new ArrayList<>();
	private String formaPagamento;
	private String dataFormatada;
	private LocalDateTime data;// = LocalDateTime.now();
	private int posicao=0;
	private DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static Random gerador = new Random();

	
	public Venda() {
		this.ID = geraID();
		this.dataFormatada = dtf.format(LocalDateTime.now());
		this.data = LocalDateTime.now();
	}
	
	public Venda(Cliente cliente, Produto p, int unidade, String formaPagamento) {
		this.ID = geraID();
		this.cliente = cliente;
		this.formaPagamento = formaPagamento;
		this.dataFormatada = dtf.format(LocalDateTime.now());
		this.data = LocalDateTime.now();
		carrinho.add(p);
		unid.add(unidade);		
	}

	public static int geraID() {
		return gerador.nextInt(200);
	}
	public int getID() {
		return ID; 
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getDataFormatada() {
		return dataFormatada;
	}
	public void setDataFormatada(String s) {
		this.dataFormatada = s;
	}
	public LocalDateTime getData() {
		return data;
	}
	public int getNProdutos() {
		return posicao;
	}
	
	//public static void setPosicao() {
		//posicao=0;
	//}
	
	public List<String> getListaVenda(){
		List<String> lista = new ArrayList<>();
		int aux = 0;
		//System.out.println();
		
		for (Produto x:carrinho) {
			lista.add(x.getNome()+" - "+unid.get(aux));
			
			aux++;
		}
		
		return lista;
	}
	public void setUnidades(int index, int unidades) {
		unid.remove(index);
		unid.add(index, unidades);
	}

	public void adicionarCarrinho(Produto p, int unidades) {
		carrinho.add(p);
		unid.add(unidades);
		posicao++;
	}
	
	public double precoTotal() {
		double preco = 0; 
		for(int i=0; i<=posicao-1;i++) {
			System.out.println(carrinho.get(i)+"-----"+unid.get(i));
			preco += carrinho.get(i).getPreco()*unid.get(i);
			//preco += produto[i].getPreco()*quantidade[i];
		}
		return preco;
	}
	
	public boolean vender() {
		int i=0;
		int aux=0;
		do {
			Produto produto = this.carrinho.get(i);
			int unidades = unid.get(i);
			System.out.println();
			if(Estoque.retirar(produto, unidades)) {
				aux++;
			}
			i++;
		}while(i<=posicao-1);
		
		if(aux != 0) {
			
			return true;
		}else{
			return false;
		}
		
	}
	
	
	@Override
	public boolean equals(Object p) {
		
		if(this.ID == ((Venda) p).getID()) {
			return true;
		}else {
			return false;
		}
	}
}
