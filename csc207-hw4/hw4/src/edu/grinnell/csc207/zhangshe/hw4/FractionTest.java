package edu.grinnell.csc207.zhangshe.hw4;

import java.math.BigInteger;
import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;

public class FractionTest {

	@Test
	public void testingLCD() {

		Fraction test = new Fraction(1, 13);
		Fraction test2 = new Fraction(1, 5);

		assertEquals("Case 1: Denominators are relatively prime",
				new BigInteger("65"), test.LCD(test2));

		test = new Fraction(1, 10);
		assertEquals("Case 2: One denominator is a multiple of another",
				new BigInteger("10"), test.LCD(test2));
		assertEquals("Case 2: One denominator is a multiple of another",
				new BigInteger("10"), test2.LCD(test));

	}// testingLCD

	@Test
	public void testingGCD() {
		Fraction test3 = new Fraction(1, 15);
		Fraction test4 = new Fraction(1, 6);
		assertEquals("Testing GCD screens", new BigInteger("3"),
				test3.GCD(test4));
		Fraction test5 = new Fraction(1, 20);
		Fraction test6 = new Fraction(1, 15);
		assertEquals("Testing GCD screens", new BigInteger("5"),
				test6.GCD(test5));
	}// testingGCD

	@Test
	public void testingmultiply() throws Exception {
		// special case
		Fraction test0 = new Fraction(0, 5);
		Fraction test1 = new Fraction(1, 10);
		assertEquals("Testing multiply", "0",
				(test0.multiplyFraction(test1)).toString());

		test0 = new Fraction(2, 9);
		test1 = new Fraction(5, 18);
		assertEquals("Testing multiply positive fraction", "5/81",
				(test0.multiplyFraction(test1)).toString());

		test0 = new Fraction(-2, 9);
		test1 = new Fraction(-5, 18);
		assertEquals("Testing multiply negative fraction", "5/81",
				(test0.multiplyFraction(test1)).toString());

		test0 = new Fraction(2, 9);
		test1 = new Fraction(-5, 18);
		assertEquals("Testing multiply negative fraction", "-5/81",
				(test0.multiplyFraction(test1)).toString());

		try {
			test0 = new Fraction(0, 0);
			assertEquals("The denominator is zero", "0", test0
					.multiplyFraction(test0).toString());
			fail("Exception was not thrown");
		} catch (Exception e) {
			System.out.println("Exception thrown.");
		} // try

	}// testingmultiply ()

	@Test
	public void testingdivide() throws Exception {
		// special case
		Fraction test0 = new Fraction(0, 5);
		Fraction test1 = new Fraction(1, 10);
		assertEquals("Testing multiply", "0", (test0.divide(test1)).toString());

		try {
			test0 = new Fraction(0, 0);
			assertEquals("The denominator is zero", "0", test0.divide(test0)
					.toString());
			fail("Exception was not thrown");
		} catch (Exception e) {
			System.out.println("Exception thrown.");
		} // try

		test0 = new Fraction(2, 9);
		test1 = new Fraction(5, 18);
		assertEquals("Testing multiply positive fraction", "4/5",
				(test0.divide(test1)).toString());

		test0 = new Fraction(-2, 9);
		test1 = new Fraction(-5, 18);
		assertEquals("Testing multiply negative fraction", "4/5",
				(test0.divide(test1)).toString());

		test0 = new Fraction(2, 9);
		test1 = new Fraction(5, -18);
		assertEquals("Testing multiply negative fraction", "-4/5",
				(test0.divide(test1)).toString());

	} // testingdivide

	@Test
	public void testingsubtract() {
		Fraction test0 = new Fraction(2, 9);
		Fraction test1 = new Fraction(5, -18);
		assertEquals("1/2", (test0.subtract(test1)).toString());
		
		test0 = new Fraction(2, 9);
		test1 = new Fraction(5, 9);
		assertEquals("-1/3", (test0.subtract(test1)).toString());
		
		test0 = new Fraction(-2, 9);
		test1 = new Fraction(-5, 9);
		assertEquals("1/3", (test0.subtract(test1)).toString());

	} //testingsubtract

	@Test
	public void testFractional() throws Exception {
		Fraction f = new Fraction(11, 3);
		assertEquals("2/3", f.fractional().toString());

		f = new Fraction(1, 2);
		assertEquals("1/2", f.fractional().toString());

		f = new Fraction(5, 2);
		assertEquals("1/2", f.fractional().toString());

		f = new Fraction(4, 2);
		assertEquals("0", f.fractional().toString());

	} // testFractional()

	@Test
	public void testingtoFraction() {

		Fraction test0 = new Fraction(new BigInteger("1"), new BigInteger("5"));
		assertEquals(test0.toString(), (Fraction.toFraction("1/5").toString()));

		
		Fraction test1 = new Fraction(new BigInteger("0"), new BigInteger("5"));
		assertEquals(test1.toString(), (Fraction.toFraction("0/5").toString()));
	} // testingtoFraction

}// Class FractionTest
