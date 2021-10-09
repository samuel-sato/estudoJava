package testes;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import entities.DadoCliente;
import modelo.Cliente;

class TesteCliente {

	Cliente c0 = new Cliente("ANONIMO", "OOOOO", "teste@gmail", "0000000", "000000");
	Cliente c1 = new Cliente("ANONIMO1", "OOOOO", "teste@gmail", "0000000", "000000");
	Cliente c2 = new Cliente("ANONIMO1", "OOOOO", "teste@gmail", "0000000", "000000");
	Cliente c3 = new Cliente("ANONIMO1", "OOOOO", "teste@gmail", "1111111", "000000");
	
	
	@Test
	void testCadastrarCliente() {
		//assertTrue(DadoCliente.adicionar(c0));
		assertTrue(DadoCliente.adicionar(c1));
	}
	@Test
	void testBuscaClienteNome() {
		DadoCliente.adicionar(c0);
		assertEquals(DadoCliente.buscar("ANONIMO"), c0.toString());
	}
	@Test
	void testClientesIguais() {
		assertFalse(c0.equals(c1));
		assertTrue(c1.equals(c2));
		assertFalse(c1.equals(c3));

	}
	

}
