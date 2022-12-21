package br.com.wall.cm.modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.wall.cm.excecao.ExplosaoException;

class CampoTeste {

	private Campo campo;

	@BeforeEach
	void iniciarCampo() {
		campo = new Campo(3, 3);
	}

	@Test
	void testeVizinhoRealDistancia1Direita() {
		Campo vizinho = new Campo(3, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado); 
	}

	@Test
	void testeVizinhoRealDistancia1Esquerda() {
		Campo vizinho = new Campo(3, 4);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoRealDistancia1Emcima() {
		Campo vizinho = new Campo(2, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoRealDistancia1Embaixo() {
		Campo vizinho = new Campo(4, 3);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeVizinhoRealDistancia2() {
		Campo vizinho = new Campo(2, 2);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertTrue(resultado);
	}

	@Test
	void testeNaoVizinho() {
		Campo vizinho = new Campo(1, 1);
		boolean resultado = campo.adicionarVizinho(vizinho);
		assertFalse(resultado);
	}

	@Test
	void testeValorPadraoAtributoMarcao() {

		assertFalse(campo.IsMarcado());
	}

	@Test
	void testeAltenarMarcao() {
		campo.alternarMarcador();
		assertTrue(campo.IsMarcado());
	}

	@Test
	void testeAltenarMarcacaoDuasChamadas() {
		campo.alternarMarcador();
		campo.alternarMarcador();
		assertFalse(campo.IsMarcado());
	}

	@Test
	void testeAbrirNaoMinadoNaoMarcado() {
		assertTrue(campo.abrir());
	}

	@Test
	void testeAbrirNaoMinadoMarcado() {
		campo.alternarMarcador();
		assertFalse(campo.abrir());
	}

	@Test
	void testeAbrirMinadoMarcado() {
		campo.alternarMarcador();
		campo.minar();
		assertFalse(campo.abrir());
	}

	@Test
	void testeAbrirMinadoNaoMarcado() {
		campo.minar();

		assertThrows(ExplosaoException.class, () -> {
			campo.abrir();
		});
	}
	
	@Test
	void testeAbrirComVizinhos() {
		Campo campo22 = new Campo(2,2);
		Campo campo11 = new Campo(1,1);
		
		campo22.adicionarVizinho(campo11);
		
		campo.adicionarVizinho(campo22);
		campo.abrir();
		
		assertTrue(campo22.IsAberto() && campo11.IsAberto());
	}
}
