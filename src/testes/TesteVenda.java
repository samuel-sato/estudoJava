package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import entities.DadoVenda;
import modelo.Cliente;
import modelo.Perfume;
import modelo.Venda;

class TesteVenda {
	
	Perfume p1 = new Perfume("Perfume1", "MARCA", 99.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
	Cliente c1 = new Cliente("Ana", "12345678", "ana@gmail.com", "098755241", "1245213425");
	Venda v1 = new Venda(c1, p1, 1, "Dinheiro");
	Venda v2 = new Venda(c1, p1, 3, "Cartão");
	

	@Test
	void testAdicionarVenda() {
		assertTrue(DadoVenda.adicionar(v1));
		assertFalse(DadoVenda.adicionar(v1));
	}
	
	@Test
	void testVenda() {
		assertFalse(v1.vender()); //retorna falso pois não atualizai estoque
	}

}
