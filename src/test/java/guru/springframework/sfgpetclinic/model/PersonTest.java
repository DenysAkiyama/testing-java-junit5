package guru.springframework.sfgpetclinic.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("model")
class PersonTest {

	@Test
	void groupedAssertions() {
		//given
		Person person = new Person(1L, "João", "Batista");
		
		//then
		assertAll("Teste de set de properties(props)",
				() -> assertEquals(person.getFirstName(), "João"),
				() -> assertEquals(person.getLastName(), "Batista"));
	}

	@Test
	void groupedAssertionsMsgs() {
		//given
		Person person = new Person(1L, "João", "Batista");
		
		//then
		assertAll("Teste de set de properties(props)",
				() -> assertEquals(person.getFirstName(), "João", "### Nome com falha!!! ###"),
				() -> assertEquals(person.getLastName(), "Batista", "### Sobrenome com falha!!! ###"));
	}
}
