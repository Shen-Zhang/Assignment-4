package edu.grinnell.csc207.zhangshe.hw4;

import java.io.BufferedReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class CalcExpt {

	public static void main(String[] args) throws Exception {
		PrintWriter pen = new PrintWriter(System.out, true); 
		pen.println("Welcome to the calculator! ");
		java.io.InputStreamReader istream;
		istream = new java.io.InputStreamReader(System.in); 
		BufferedReader reader = new BufferedReader(istream);
		String expression = " "; 
		
		while (expression.compareTo("q") != 0) {
			pen.println("Please enter the expression, or q to quit: ");

			String str = null; 
			try {
				expression = reader.readLine();
				if (expression.compareTo("q") == 0) {
					break;
				} else {
					Fraction result = Calculator.evaluate(expression);
					if (result.denom.compareTo(BigInteger.ONE) == 0) {
						str = result.toString().substring(0,
								result.toString().indexOf('/'));
					} else {
						str = result.toString();
					} //else
					pen.println(expression + " = " + str);
				}// outer else
			} catch (Exception e) {

				if (expression.replace(" ", "").matches("[a-zA-Z]*")
						&& (expression.compareTo("") != 0)) {
					pen.println("Invalid Characters");
				} else if (expression.compareTo(" ") == 0) {
					pen.println("Empty Input");
				} else if (expression.indexOf(' ') < 0) {
					pen.println("Invalid Expression: Expression Needs Spaces");
				} else {
					pen.println("Invalid Input");
				} // else 
			} // catch
		}// while
		pen.println("Byebye! ");
		pen.flush();
		reader.close();
	} // main

} // class CalcExpt
