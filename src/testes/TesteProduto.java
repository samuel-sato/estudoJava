package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import entities.DadoProduto;
import entities.Estoque;
import modelo.Perfume;

class TesteProduto {
	
	Perfume p1 = new Perfume("Perfume1", "MARCA", 99.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
	Perfume p2 = new Perfume("Perfume2", "MARCA", 98.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
	Perfume p3 = new Perfume("Perfume3", "MARCA", 97.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
	Perfume p4 = new Perfume("Perfume4", "MARCA", 96.99, "DESCRIÇÂO PERFUME",500, "MASCULINO", "LAVANDA");
	@Test
	void testAdicionarProduto() {
		assertTrue(DadoProduto.adicionar(p1));
	}
	
	@Test
	void testAdicionarProdutoEstoque() {
		assertTrue(Estoque.adicionar(p2, 1));
		assertFalse(Estoque.adicionar(p2, 1)); //produto ja adicionado - acrescentado quantidade
	}
	
	@Test
	void testRetirarProdutoEstoque() {
		assertTrue(Estoque.retirar(p2, 1));
		assertFalse(Estoque.retirar(p2, 2));		
	}
	
	@Test
	void testEditarProdutoEmEstoque() {
		assertTrue(Estoque.adicionar(p3, 1));
		assertTrue(Estoque.editarProduto(p3.getID(), p1));
		assertFalse(Estoque.editarProduto(p2.getID(), p4));
	}
	
	@Test
	void testBuscaLista() {
		assertEquals(DadoProduto.buscar("Perfume1"), p1.toString());
		assertEquals(DadoProduto.buscar("Perfume2"), "Não há produtos com esse nome");
		assertEquals(DadoProduto.buscar("Perfume5"), "Não há produtos com esse nome");
	}
	

}
