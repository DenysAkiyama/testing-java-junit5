package guru.springframework.sfgpetclinic.controllers;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.time.Duration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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
	
	@Disabled("Demonstração de Timeout")
	@Test
	void testTimeOut() {
		
		assertTimeout(Duration.ofMillis(100),
			() -> {
				Thread.sleep(5000);
				
				System.out.println("Eu cheguei aqui");
			}
		);
	}
	
	@Disabled("Demonstração de Timeout Preventivo")
	@Test
	void testTimeOutPreempt() {
		
		assertTimeoutPreemptively(Duration.ofMillis(100),
			() -> {
				Thread.sleep(5000);
				
				System.out.println("Eu dormi!!!");
			}
		);
	}
	
	@Test
	void testAssumptionTrue() {
		
		assumeTrue("Guru".equalsIgnoreCase(System.getenv("GURU_RUNTIME")));
	}
	
	@Test
	void testAssumptionTrueReallyTrue() {
		
		assumeTrue("Guru".equalsIgnoreCase(("GURU")));
	}

}
