package io.github.dbc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class ColorCodeCheckerTest {

	private ColorCodeChecker colorCodeChecker;

	@BeforeEach
	void setUp() {
		colorCodeChecker = new ColorCodeChecker();
	}

	@ParameterizedTest(name = "getColorCode({arguments})")
	@CsvSource({
			"Black, 0",
			"Brown, 1",
			"Red, 2",
			"Orange, 3",
			"Yellow, 4",
			"Green, 5",
			"Blue, 6",
			"Violet, 7",
			"Grey, 8",
			"White, 9"
	})
	void getColorCode(String color, int expectedCode) {
		int actualColorCode = colorCodeChecker.getColorCode(color);
		Assertions.assertEquals(expectedCode, actualColorCode);
	}

	@ParameterizedTest(name = "getColorCode({arguments})")
	@ValueSource(strings = {"Salmon", "Magenta", "Cyan", "Lime", "Aqua", "Fuchsia", "Olive", "Maroon", "Navy", "Teal"})
	void getColorCodeForInvalidColors(String color) {
		int actualColorCode = colorCodeChecker.getColorCode(color);
		Assertions.assertEquals(Integer.MIN_VALUE, actualColorCode);
	}
}