package modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe que modela Produto Perfume
 * @author samuel
 * @version 1.0
 */
public class Perfume extends Produto{
	private int volume;
	private String genero;
	private String familiaOufativa;
	
	private static List<Perfume> listaPerfumes= new ArrayList<>();
	
	public int getVolume() {
		return volume;
	}
	public void setVolume(int volume) {
		this.volume = volume;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getFamiliaOufativa() {
		return familiaOufativa;
	}
	public void setFamiliaOufativa(String familiaOufativa) {
		this.familiaOufativa = familiaOufativa;
	}
	
	public Perfume(String nome, String marca, double preco, String descricao,int volume, String genero, String familiaOufativa) {
		//super();
		this.ID = Produto.geraID();
		this.nome = nome;
		this.marca = marca;
		this.preco = preco;
		this.descricao = descricao;
		this.volume = volume;
		this.genero = genero;
		this.familiaOufativa = familiaOufativa;
	}
	
	@Override
	public String toString() {
		return "Nome: "+this.nome+"; Marca: "+this.marca+"; Preço: "+this.preco+"; Descrição: "
	+this.descricao+"; Volume: "+this.volume+"; Gênero: "+this.genero+"; Família Oufativa: "+this.familiaOufativa;
	}
	
}
