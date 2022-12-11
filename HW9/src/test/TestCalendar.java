package test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.GregorianCalendar;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import main.Calendar;

class TestCalendar {
	
	//note that all test values are created in a way, so the Junit Test returns a accepted return, to allow not accepted values, just change the Values after the Condition mentioned in the comment above the Value Source
	@ParameterizedTest
	//The test values here are all leap years 
	@ValueSource(ints = {1968,1972,1956,1948,1992})
	public void Should_return_true(int year) {
		Calendar calendar = new Calendar(year);
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		
		assertEquals(cal.isLeapYear(year),calendar.isLeapYear());
		
		assertTrue(calendar.isLeapYear());
	}

	@ParameterizedTest
	//The test values here aren't leap years 
	@ValueSource(ints = {1901,1973,1957,1947,1993})
	public void Should_return_false(int year) {
		Calendar calendar = new Calendar(year);
		GregorianCalendar cal = (GregorianCalendar) GregorianCalendar.getInstance();
		
		assertEquals(cal.isLeapYear(year),calendar.isLeapYear());
		
		assertFalse(calendar.isLeapYear());
	}

	@ParameterizedTest
	//Here both leap and non leap years are Test values
	@ValueSource(ints = {1968,1973,1956,1949,1992})
	public void Should_return_if_year_is_leap(int year) {
		
		Calendar calendar = new Calendar(year);
		GregorianCalendar cal = new GregorianCalendar();
		
		assertEquals(cal.isLeapYear(year),calendar.isLeapYear());
		
		boolean LeapYear = calendar.isLeapYear();
		
		if(calendar.isLeapYear() == true) {
			assertTrue(LeapYear);
		}else {
			assertFalse(LeapYear);
		}
	}

	@ParameterizedTest
	//here both leap and non leap years are Test values, but they are located at the edges of the 20th Century
	@ValueSource(ints = {1900,1901,1902,1903,1904,1996,1997,1998,1999})
	public void Should_return_if_year_is_leap_bounderytesting(int year) {
		
		Calendar calendar = new Calendar(year);
		GregorianCalendar cal = new GregorianCalendar();
		
		assertEquals(cal.isLeapYear(year),calendar.isLeapYear());
		
		boolean LeapYear = calendar.isLeapYear();
		
		if(calendar.isLeapYear() == true) {
			assertTrue(LeapYear);
		}else {
			assertFalse(LeapYear);
		}
	}
}
