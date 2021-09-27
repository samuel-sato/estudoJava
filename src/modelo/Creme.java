package modelo;

public class Creme extends Produto{

	private String tipoPele;
	private String tipoCreme;
	private int massa;
	
	public String getTipoPele() {
		return tipoPele;
	}
	public void setTipoPele(String tipoPele) {
		this.tipoPele = tipoPele;
	}
	public String getTipoCreme() {
		return tipoCreme;
	}
	public void setTipoCreme(String tipoCreme) {
		this.tipoCreme = tipoCreme;
	}
	public int getMassa() {
		return massa;
	}
	public void setMassa(int massa) {
		this.massa = massa;
	}
	public Creme(String nome, String marca, double preco, String descricao, String tipoPele, String tipoCreme, int massa) {
		super();
		this.nome=nome;
		this.marca=marca;
		this.preco=preco;
		this.descricao=descricao;
		this.tipoPele = tipoPele;
		this.tipoCreme = tipoCreme;
		this.massa = massa;
	}
	
	
}
