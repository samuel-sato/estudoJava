package modelo;

public class Cliente {

	private String nome;
	private String telefone;
	private String email;
	private String CPF;
	private String CEP;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public String getCEP() {
		return CEP;
	}
	public void setCEP(String cEP) {
		CEP = cEP;
	}
	
	public Cliente(String nome, String telefone, String email, String cPF, String cEP) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.CPF = cPF;
		this.CEP = cEP;
	}
	@Override
	public boolean equals(Object c) {
		
		if(this.nome == ((Cliente) c).getNome() && this.CPF == ((Cliente) c).getCPF()) {
			return true;
		}else {
			return false;
		}
	}
	@Override
	public String toString() {
		return "Nome: "+this.nome+", Telefone: "+this.telefone+", Email: "+this.email+", CPF: "+this.CPF+", CEP:"+this.CEP;
	}
	
	
}
