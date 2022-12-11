package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import main.Calculator;


class TestCalculator {

	Calculator calculator = new Calculator();

	@Test
	public void Should_add_two_numbers_and_return_result() {
		int expectedResult = 2 + 3;
		int actualResult = calculator.add(2, 3);
		
		assertEquals(expectedResult, actualResult);
	}

	@ParameterizedTest
	@CsvSource({
		"1, 1",
		"2, 2",
		"3, 3",
		"4, 4",
		"5, 5"
	})
	public void Should_add_two_numbers_and_return_result_parameterized(int valueOne, int valueTwo) {
		assertEquals(valueOne+valueTwo,calculator.add(valueOne, valueTwo));
	}
	
	@Test
	public void Should_substract_two_numbers_and_return_result() {
		int expectedResult = 4 - 2;
		int actualResult = calculator.sub(4, 2);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Should_multiply_two_numbers_and_return_result() {
		int expectedResult = 2 * 3;
		int actualResult = calculator.multiply(2, 3);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Should_divide_two_numbers_and_return_result() {
		int expectedResult = 6 / 3;
		int actualResult = (int) calculator.divide(6, 3);
		
		assertEquals(expectedResult, actualResult);
	}
	
	@Test
	public void Should_throw_an_arithmetic_exception_if_denominator_is_zero() {
		Exception thrown = assertThrows(
				ArrayIndexOutOfBoundsException.class,
		           () -> calculator.divide(1,0),
		           "ZeroDivisionError"
		    );
		String expectedMessage = "ZeroDivisionError";
	    String actualMessage = thrown.getMessage();
	    assertEquals(expectedMessage, actualMessage);
	}
}