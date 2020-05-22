package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OwnerTest {

	@Test
	void dependentAssertions() {
		
		Owner owner = new Owner(1L, "José", "Jurrássico");
		owner.setCity("Gotham");
		owner.setTelephone("1231231234");
		
		assertAll("Testes de Propriedades",
				() -> assertAll("Propriedades de Person",
							() -> assertEquals("José", owner.getFirstName(), "Nome não combina"),
							() -> assertEquals("Jurrássico", owner.getLastName(), "Sobrenome não combina")
				),
				() -> assertAll("Propriedades de Owner",
							() -> assertEquals("Gotham", owner.getCity()),
							() -> assertEquals("1231231234", owner.getTelephone())
				)
		);
	}

}
