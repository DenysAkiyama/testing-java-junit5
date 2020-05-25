package guru.springframework.sfgpetclinic.model;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OwnerTest {
	Owner owner;
	@BeforeEach
	void setUp() throws Exception {
		owner = new Owner(1L, "José", "Jurrássico");
//		owner = new Owner(null, null, null);
	}

	
	@Test
	void dependentAssertions() {
		
		Owner owner = new Owner(1L, "José", "Jurrássico");
		
		owner.setId(1L);
		owner.setFirstName("José");
		owner.setLastName("Jurássico");
		
		owner.setCity("Gotham");
		owner.setTelephone("1231231234");
		
		assertAll("Testes de Propriedades",
				() -> assertAll("Propriedades de Person",
							() -> assertEquals("José", owner.getFirstName(), "Nome não combina"),
							() -> assertEquals("Jurássico", owner.getLastName(), "Sobrenome não combina")
				),
				() -> assertAll("Propriedades de Owner",
							() -> assertEquals("Gotham", owner.getCity()),
							() -> assertEquals("1231231234", owner.getTelephone())
				)
		);
	}
	
	@DisplayName("Teste com Asserção Hamcrest que verifica o nome da View")
	@Test
	void testIndexWithHamcrest() {
		owner.setCity("Gotham");
		assertThat(owner.getCity(), is("Gotham"));
	}

}
