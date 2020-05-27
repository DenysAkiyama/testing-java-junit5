package guru.springframework.sfgpetclinic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInfo;

@Tag("modelRepeatedTests")
public interface ModelRepeated {

	@BeforeEach
	default void beforeEachConsoleOutput(TestInfo testInfo, RepetitionInfo repetitionInfo) {
		System.out.println("Executanto Teste - "+ testInfo.getDisplayName() + " - " 
				+ "|"+ repetitionInfo.getCurrentRepetition() + "| de " +"|" + repetitionInfo.getTotalRepetitions()+"|");
	}
}
