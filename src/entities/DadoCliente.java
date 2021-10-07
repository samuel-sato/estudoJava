package entities;
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
//import modelo.Produto;


public class DadoCliente {

	private static int nCliente;
	private static int aux=0;
	private static List <Cliente> listaCliente = new ArrayList<Cliente>();
	
	
	public static int getnCliente() {
		return nCliente;
	}
	public static Cliente getCliente(int i){
		return listaCliente.get(i);
	}
	//Lista sem repetições
	public static boolean adicionar(Cliente c) {
		DadoCliente.aux=0;
		for (Cliente x: DadoCliente.listaCliente) {
			if (x.equals(c)) {
				//System.out.println("Cliente já adicionado");
				DadoCliente.aux++;
			}
		} 
		if(DadoCliente.aux==0){
			listaCliente.add(c);
			//System.out.println("cliente adicionado");
			nCliente++;
			return true;
		} else {
			return false;
		}
	}
	public static void editar(int pos, Cliente c) {
		listaCliente.remove(pos);
		
		listaCliente.add(pos, c);
		
		System.out.println("cliente alterado! ");
	}
	public static void excluir(int i) {
		listaCliente.remove(i);
		//nCliente--;
	}
	
	//alterar exibir 
	public static void exibir() {
		for (Cliente x: DadoCliente.listaCliente) {
			System.out.println(x.getNome());
		}
	}
	
	public static String buscar(String nome) {
		String resultado = "Não há clientes com esse nome";
		int aux =0;
		for (Cliente x: listaCliente) {
			if(x.getNome().equalsIgnoreCase(nome)) {
				resultado = x.toString();
				aux++; 
			}
		}
		if (aux != 0) {
			return resultado;
		}else {
			return resultado;
		}
		
	}
	
	public static List<String> nomeCliente () {
		List<String> nome = new ArrayList<String>();
		
		for (Cliente x: DadoCliente.listaCliente) {
			nome.add(x.getNome());
		}
		return nome;
	}
	public DadoCliente() {
		super();
	}
}
