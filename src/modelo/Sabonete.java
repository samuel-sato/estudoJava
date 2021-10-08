package modelo;

public class Sabonete extends Produto{

	private String tipo;
	private int massa;
	private int volume;
	private String piramideOufativa;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getMassa() {
		return massa;
	}
	public void setMassa(int massa) {
		this.massa = massa;
	}
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	
	public String getPiramideOufativa() {
		return piramideOufativa;
	}
	public void setPiramideOufativa(String piramideOufativa) {
		this.piramideOufativa = piramideOufativa;
	}
	public Sabonete(String nome, String marca, double preco, String descricao,String tipo, int massa, String piramideOufativa) {
		this.ID=Produto.geraID();
		this.nome=nome;
		this.marca=marca;
		this.preco=preco;
		this.descricao=descricao;
		this.tipo = tipo;
		this.massa = massa;
		//this.volume = volume;
		this.piramideOufativa = piramideOufativa;
	}
	@Override
	public String toString() {
		return "Nome: "+this.nome+"; Marca: "+this.marca+"; Preço: "+this.preco+"; Descrição: "
	+this.descricao+ "; Tipo: "+this.tipo+"; massa: "+this.massa+"; Piramide Oufativa: "+this.piramideOufativa;
	}
}
