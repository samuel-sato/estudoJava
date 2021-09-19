package modelo;

public abstract class Produto {
	
	protected int ID;
	protected String nome;
	protected String marca;
	protected double preco;
	protected String descricao;
	
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public boolean equals(Object p) {
		
		if(this.nome == ((Produto) p).getNome() && this.preco == ((Produto) p).getPreco()) {
			return true;
		}else {
			return false;
		}
		
	}
}
