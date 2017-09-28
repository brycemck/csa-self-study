/*
 * CoinCounter.java
 * This application will ask for a dollar value, and return the minimum amount of coins that
 * equal the dollar amount given by the user. This application assumes that half-dollar and
 * dollar coins do not exist.
 * 
 * @author Bryce McKenney
 * @version 1.0
 * @updated 20170927
 */

// Always name your package com.whatever* because ... Java! Seriously though it's a Javaism and its feedback I got on my code review when I applied for this job. Seems overly complicated if you ask me but it will give the perception you know what your doing in Java Land.
package bryce;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * In the real world, java managers want insane amounts of java documentation in the form of Javadocs.
 * In seems a bit overkill to me, but eventually you'll want to know how to write Javadocs for your methods.
 * Your Dad can show you how to get Checkstyle setup :)
 *
 * You are right to focus on your code first, though! 
 */
public class CoinCounter {
	static String inputValue = null;
	static String[] inputSplit;
	static int inputDollars = 0;
	static int inputCents = 0;
	static int quarters = 0;
	static int dimes = 0;
	static int nickels = 0;
	static int pennies = 0;
	
	private static void parseCoins() {
		int dollars = inputDollars;
		double cents = inputCents;
		
		// First, let's convert dollars into quarters
        // make this a method: numberOfQuartersFromDollars(dollars)
		CoinCounter.quarters += dollars * 4;
		
		// Now let's figure out cents
		// Quarters first
        // Same: make this a method: numberOfQuartersFromCents(cents)
		double quartersFromCents = Math.floor(cents / 25);
		CoinCounter.quarters += quartersFromCents;
		cents = cents - (quartersFromCents * 25);
		
		// Then dimes
        // Same: make a method - you get the idea. Each of these blocks of funcationality do 1 specific thing.
		double dimesFromCents = Math.floor(cents / 10);
		CoinCounter.dimes += dimesFromCents;
		cents = cents - (dimesFromCents * 10);
		
		// Nickels
		double nickelsFromCents = Math.floor(cents / 5);
		CoinCounter.nickels += nickelsFromCents;
		cents = cents - (nickelsFromCents * 5);
		
		// Finally, pennies (at this point the remaining amount of cents shouldn't
		// be able to be any other coin, so just add the cents
		CoinCounter.pennies += cents;
		
        // Call the methods you just made. No need to assign the values to the static class variables.
		System.out.println("Quarters: " + CoinCounter.quarters);
		System.out.println("Dimes: " + CoinCounter.dimes);
		System.out.println("Nickels: " + CoinCounter.nickels);
		System.out.println("Pennies: " + CoinCounter.pennies);
	}

    // Catch the IOException and print a message instead of letting the application blow up?
	private static void init() throws IOException {
        // good name for the variable. It can be a local variable instead of a static class variable.
		inputValue = JOptionPane.showInputDialog("Please input a dollar value. (x.xx format)").replace(",", ""); // remove any commas
		inputSplit = inputValue.split("\\.");
		
        // Another good oppportunity for a method. No need for the inline comment because your code will make sense.
        // if (!dollarInputIsValid(input)) {
		if (inputValue == null || !inputValue.contains(".") || inputValue.length() < 3 || inputSplit.length > 2) { // general syntax check
			System.err.println("invalid format");
			CoinCounter.init();
		} else { // passed general syntax check
			try { // check to make sure everything is a number
				inputDollars = Integer.parseInt(inputSplit[0]);
				inputCents = Integer.parseInt(inputSplit[1]);
				
                // This can probably be encapsulated into the new dollarInputIsValid(input) method.
				if (inputCents < 0 || inputCents > 99) { // make sure cent value is valid
					System.err.println("invalid format");
				} else { // everything passed
					// System.out.println("valid input");
					CoinCounter.parseCoins();
				}
			} catch (NumberFormatException nfe) {
				System.err.println("invalid format");
				CoinCounter.init();
			}
		}
	}
	public static void main(String[] args) throws IOException {
		CoinCounter.init();
	}
}
