package guru.springframework.sfgpetclinic.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.TestInfo;

import guru.springframework.sfgpetclinic.ModelRepeated;

public class PersonRepeatedTests implements ModelRepeated {

	@RepeatedTest(value = 10, name = "{displayName} : {currentRepetition} de {totalRepetitions}")
	@DisplayName("Meu teste repetido")
	void myRepeatedTest() {
		//Todo - impl
	}
	
	@RepeatedTest(5)
	void myRepeatedTestWithDI(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		System.out.println(testInfo.getDisplayName() + ": "+ repetitionInfo.getCurrentRepetition());
	}
	
	@RepeatedTest(value = 5, name = "{displayName} : {currentRepetition} de {totalRepetitions}")
	@DisplayName("Minha Tarefa Repetida")
	void myAssignmentRepeated() {
		//Todo - impl
	}
	
}
