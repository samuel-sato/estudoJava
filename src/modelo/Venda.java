package modelo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import entities.Estoque;

public class Venda {
	
	private int ID;
	private Cliente cliente;
	public static  List<Produto> carrinho = new ArrayList<>();
	public static List<Integer> unid = new ArrayList<>();
	private String formaPagamento;
	private String dataFormatada;
	private LocalDateTime data;// = LocalDateTime.now();
	private static int posicao=0;
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
	
	public static void setPosicao() {
		Venda.posicao=0;
	}


	public void adicionarCarrinho(Produto p, int unidades) {
		Venda.carrinho.add(p);
		Venda.unid.add(unidades);
		/*
		if(Venda.posicao==0) {
			
			this.produto[0] = p;
			this.quantidade[0] = unidades;
			Venda.posicao++;
			//System.out.println("aaa 1 :"+Venda.posicao);
			//System.out.println(this.produto[0]);
			
		} else {
			this.produto[Venda.posicao] = p;
			this.quantidade[Venda.posicao] = unidades;
			Venda.posicao++;
			//System.out.println("aaaaaaaaa :"+Venda.posicao);
			
		}
		*/
		//System.out.println(Venda.posicao);
		//System.out.println(this.produto[Venda.posicao]);
		//listaProdutos();
		//System.out.println();
	}
	public double precoTotal() {
		int preco = 0; 
		for(int i=0; i<=posicao-1;i++) {
			preco += carrinho.get(i).getPreco()*unid.get(i);
			//preco += produto[i].getPreco()*quantidade[i];
		}
		return preco;
	}
	
	public boolean vender() {
		int i=0;
		int aux=0;
		do {
			Produto produto = Venda.carrinho.get(i);
			int unidades = Venda.unid.get(i);
			System.out.println();
			if(Estoque.retirar(produto, unidades)) {
				aux++;
			}
			i++;
		}while(i<=Venda.posicao-1);
		if(aux != 0) {
			Venda.carrinho.clear();
			Venda.unid.clear();
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
