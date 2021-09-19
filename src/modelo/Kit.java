package modelo;

public class Kit {

	private Perfume perfume;
	private Sabonete sabonete;
	private Creme creme;
	
	public Perfume getPerfume() {
		return perfume;
	}
	public void setPerfume(Perfume perfume) {
		this.perfume = perfume;
	}
	public Sabonete getSabonete() {
		return sabonete;
	}
	public void setSabonete(Sabonete sabonete) {
		this.sabonete = sabonete;
	}
	public Creme getCreme() {
		return creme;
	}
	public void setCreme(Creme creme) {
		this.creme = creme;
	}
	
	public Kit(Perfume perfume, Sabonete sabonete, Creme creme) {
		super();
		this.perfume = perfume;
		this.sabonete = sabonete;
		this.creme = creme;
	}
	
	
}
