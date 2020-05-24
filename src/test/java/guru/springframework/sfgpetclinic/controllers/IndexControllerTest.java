package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexControllerTest {

	IndexController controller;
	
	@BeforeEach
	void setUp() {
		controller = new IndexController();
	}

	@DisplayName("Teste que verifica o nome da View retornada para a página index")
	@Test
	void testIndex() {
		assertEquals("index", controller.index());
		assertEquals("index", controller.index(), "### View Errada Retornada ###");
		
		assertEquals("index", controller.index(), () -> "Outra Mensagem Cara "+
		" pacas");
	}

	@DisplayName("Teste de exception")
	@Test
	void testOupsHandler() {
		assertThrows(ValueNotFoundException.class,
			() -> {
				controller.oopsHandler();
			}
		);
	}

}
