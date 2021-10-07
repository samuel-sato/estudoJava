package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import entities.Estoque;

public class Venda {
	
	private Cliente cliente;
	public static  List<Produto> carrinho = new ArrayList<>();
	public static List<Integer> unid = new ArrayList<>();
	private static Produto[] produto = new Produto[10];
	private static int quantidade[] = new int[10];
	private String formaPagamento;
	private LocalDateTime data;
	private static int posicao=0;

	
	public Venda() {
		super();
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

	public LocalDateTime getData() {
		return data;
	}
	
	public static void setPosicao() {
		Venda.posicao=0;
	}


	public void adicionarCarrinho(Produto p, int unidades) {
		Venda.carrinho.add(p);
		Venda.unid.add(unidades);
		if(Venda.posicao==0) {
			
			this.produto[0] = p;
			this.quantidade[0] = unidades;
			Venda.posicao++;
			System.out.println("aaa 1 :"+Venda.posicao);
			System.out.println(this.produto[0]);
			
		} else {
			this.produto[Venda.posicao] = p;
			this.quantidade[Venda.posicao] = unidades;
			Venda.posicao++;
			System.out.println("aaaaaaaaa :"+Venda.posicao);
			
		}
		
		System.out.println(Venda.posicao);
		//System.out.println(this.produto[Venda.posicao]);
		//listaProdutos();
		System.out.println();
	}
	public double precoTotal() {
		int preco = 0; 
		for(int i=0; i<=posicao-1;i++) {
			preco += produto[i].getPreco();
		}
		return preco;
	}
	
	//venda idantificada
	public void vender(Cliente cliente) {
		//super();
		this.cliente = cliente;
		//this.produto = produto;
		//this.formaPagamento = formaPagamento;
		this.data = LocalDateTime.now();
		if(this.posicao==0) {
			Estoque.retirar(produto[0], quantidade[0]);
		} else {
			for(int i=0; i<=this.posicao-1;i++) {
				Produto produto = this.produto[i];
				int unidades = this.quantidade[i];
				Estoque.retirar(produto, unidades);
			}
		}				
	}
	//venda anonima
	public void vender(String formaPagamento, Estoque estoque) {
		//super();
		this.formaPagamento = formaPagamento;
		this.data = LocalDateTime.now();
		if(this.posicao==0) {
			Estoque.retirar(produto[0], quantidade[0]);
		} else {
			for(int i=0; i<=this.posicao-1;i++) {
				Produto produto = this.produto[i];
				int unidades = this.quantidade[i];
				Estoque.retirar(produto, unidades);
			}
		}
	}
	public void vender() {
		int i=0;
		do {
			Produto produto = Venda.carrinho.get(i);
			int unidades = Venda.unid.get(i);
			//System.out.println(Venda.produto[1]);//dando valor null
			System.out.println();
			Estoque.retirar(produto, unidades);
			i++;
		}while(i<=Venda.posicao-1);
		Venda.carrinho.clear();
		Venda.unid.clear();
		/*
		for(int i=0; i<=Venda.posicao;i++) {
			Produto produto = this.produto[i];
			int unidades = this.quantidade[i];
			System.out.println(produto);//dando valor null
			Estoque.retirar(produto, unidades);
		}
		*/
		
	}
	
	public void listaProdutos() {
		
	}
}
