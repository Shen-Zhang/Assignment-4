package edu.grinnell.csc207.zhangshe.hw4;

import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void test() throws Exception {
		Fraction a = new Fraction(new BigInteger("2"), new BigInteger("3"));

		assertEquals("1/2", Calculator.evaluate("2/3 + 1/3 * 1/2").toString());
		assertEquals("1/2", Calculator.evaluate("1/2").toString());
		assertEquals("3/2", Calculator.evaluate("2/3 + 1/3 + 1/2").toString());
		assertEquals("r0", "3/2", Calculator.evaluate("r0 = 2/3 + 1/3 + 1/2")
				.toString());
		assertEquals("15/2", "15/2", Calculator.evaluate("r0 + 6").toString());
		assertEquals("3", "3/1", Calculator.evaluate("r0 + r0").toString());
		assertEquals("r1", "9/2", Calculator.evaluate("r1 = r0 + r0 + 3/2")
				.toString());
		assertEquals("r0 reassigned", "4/5", Calculator.evaluate("r0 = 4 / 5")
				.toString());

		String[] strArray = { "2/3 + 1/3 * 1/2", "1/2", "2/3 + 1/3 + 1/2" };
		
		Fraction[] frac = Calculator.evaluate(strArray);
		assertEquals("1/2", frac[0].toString());
		assertEquals("1/2", frac[1].toString());
		assertEquals("3/2", frac[2].toString());
	} // test()

} // CalculatorTest
