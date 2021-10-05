package modelo;

import java.time.LocalDateTime;

import entities.Estoque;

public class Venda {
	
	private Cliente cliente;
	private Produto[] produto = new Produto[5];
	private int quantidade[] = new int[5];
	private String formaPagamento;
	private LocalDateTime data;
	
	private int posicao=0;
	
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


	public void adicionarCarrinho(Produto p, int unidades) {
		if(this.posicao==0) {
			this.produto[0] = p;
			this.quantidade[0] = unidades;
			this.posicao++;
		} else {
			this.produto[this.posicao] = p;
			this.quantidade[this.posicao] = unidades;
			this.posicao++;
		}
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
		for(int i=0; i<=this.posicao-1;i++) {
			Produto produto = this.produto[i];
			int unidades = this.quantidade[i];
			Estoque.retirar(produto, unidades);
		}
	}
	
	public void listaProdutos() {
		for(int i=0; i<=this.posicao-1;i++) {
			System.out.println(this.produto[i]+" : "+this.quantidade[i]);
		}
	}
	
	public Venda() {
		super();
	}
}
