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

import java.io.IOException;
import javax.swing.JOptionPane;

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
		CoinCounter.quarters += dollars * 4;
		
		// Now let's figure out cents
		// Quarters first
		double quartersFromCents = Math.floor(cents / 25);
		CoinCounter.quarters += quartersFromCents;
		cents = cents - (quartersFromCents * 25);
		
		// Then dimes
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
		
		System.out.println("Quarters: " + CoinCounter.quarters);
		System.out.println("Dimes: " + CoinCounter.dimes);
		System.out.println("Nickels: " + CoinCounter.nickels);
		System.out.println("Pennies: " + CoinCounter.pennies);
	}
	private static void init() throws IOException {
		inputValue = JOptionPane.showInputDialog("Please input a dollar value. (x.xx format)").replace(",", ""); // remove any commas
		inputSplit = inputValue.split("\\.");
		
		if (inputValue == null || !inputValue.contains(".") || inputValue.length() < 3 || inputSplit.length > 2) { // general syntax check
			System.err.println("invalid format");
			CoinCounter.init();
		} else { // passed general syntax check
			try { // check to make sure everything is a number
				inputDollars = Integer.parseInt(inputSplit[0]);
				inputCents = Integer.parseInt(inputSplit[1]);
				
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