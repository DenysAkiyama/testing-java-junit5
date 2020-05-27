package guru.springframework.sfgpetclinic.model;

import static org.hamcrest.MatcherAssert.assertThat;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import guru.springframework.sfgpetclinic.CustomArgsProvider;
import guru.springframework.sfgpetclinic.ModelTests;

class OwnerTest implements ModelTests{
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
	
	@DisplayName("Value Source Test ")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@ValueSource(strings = {"Spring", "Framework", "Guru"})
	void testValueSource(String val) {
		System.out.println(val);
	}
	
	@DisplayName("Enum Source Test ")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@EnumSource(OwnerType.class)
	void enumTest(OwnerType ownerType) {
		System.out.println(ownerType);
	}
	
	@DisplayName("CSV Input Test ")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@CsvSource({
		"SP, 1, 1",
		"RJ, 2, 2",
		"ES, 3, 1"
	})
	void csvInputTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + " : " + val2);
	}

	@DisplayName("CSV Test From File")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@CsvFileSource(resources = "/input.csv", numLinesToSkip = 1)
	void csvFromFileTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + " : " + val2);
	}
	
	@DisplayName("Method Provider Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@MethodSource("getArgs")
	void fromMethodTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + " : " + val2);
	}
	
	static Stream<Arguments> getArgs(){
		return Stream.of(
				Arguments.of("FL", 1, 1),
				Arguments.of("OH", 2, 8),
				Arguments.of("MI", 3, 5)
		);
	}
	
	@DisplayName("Custom Provider Test")
	@ParameterizedTest(name = "{displayName} - [{index}] {arguments}")
	@ArgumentsSource(CustomArgsProvider.class)
	void fromCustomProviderTest(String stateName, int val1, int val2) {
		System.out.println(stateName + " = " + val1 + " : " + val2);
	}
}
