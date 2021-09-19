package entities;
import modelo.Produto;

public class ControleProduto {
	private Produto[] listaProdutos = new Produto[50];
	private int nProduto=0;
	private int aux=0;
	
	
	public void adicionarProduto(Produto p) {
		if (this.nProduto == 0) {
			this.listaProdutos[0] = p;
			p.setID(this.nProduto);
			this.nProduto++;
		} else {
			for (int i=0; i<=this.nProduto;i++) {
				if(this.listaProdutos[i].equals(p)) {
					System.out.println("Produto já adicionado");
					aux++;
				} 
			}
			if(aux==0) {
				this.listaProdutos[0] = p;
				p.setID(this.nProduto);
				this.nProduto++;
			}
		}
	}
	
	public void editarProduto() {
		
	}
	
	public void excluirProduto() {
		
	}
}
