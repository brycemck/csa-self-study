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

package com.bryce;

import javax.swing.JOptionPane;

/**
 * In the real world, java managers want insane amounts of java documentation in the form of Javadocs.
 * I think this is largely because some programmers don't write expressive code that is comprehensible so instead of enforcing good code,
 * they largely rely on documentation. Don't be the guy that can't write expressive code. You don't seem to have a problem with this.
 * eventuallyyou'll want to know how to write Javadocs for your methods. Your Dad can show you how to get Checkstyle setup :)
 *
 * You are right to focus on your code first, though! 
 */
public class CoinCounter {
	static int inputDollars = 0;
	static double inputCents = 0;
	
	private static String askForDollars() {
	  return JOptionPane.showInputDialog("Please input a dollar value. (x.xx format)").replace(",", ""); // remove any commas
	}
	
	private static double numberOfQuartersFromDollars(int dollars) {
		return dollars * 4;
	}
	private static double numberOfQuartersFromCents(double cents) {
		inputCents = inputCents - (Math.floor(cents / 25) * 25);
		return Math.floor(cents / 25);
	}
	private static double numberOfDimesFromCents(double cents) {
		inputCents = inputCents - (Math.floor(cents / 10) * 10);
		return Math.floor(cents / 10);
	}
	private static double numberOfNickelsFromCents(double cents) {
		inputCents = inputCents - (Math.floor(cents / 5) * 5);
		return Math.floor(cents / 5);
	}
	
	private static void parseCoins() {
		System.out.println("Quarters: " + (numberOfQuartersFromDollars(inputDollars) + numberOfQuartersFromCents(inputCents)));
		System.out.println("Dimes: " + numberOfDimesFromCents(inputCents));
		System.out.println("Nickels: " + numberOfNickelsFromCents(inputCents));
		System.out.println("Pennies: " + inputCents);
	}

	private static boolean isDollarInputValid(String input) {
    String[] inputSplit = input.split("\\.");
    try {
      inputDollars = Integer.parseInt(inputSplit[0]);
      inputCents = Integer.parseInt(inputSplit[1]);
      
      if (input == null || !input.contains(".") || input.length() < 3 || inputSplit.length > 2 || inputCents < 0 || inputCents > 99) {
        return false;
      } else {
        return true;
      }
    } catch (NumberFormatException nfe) {
      return false;
    }
	}
	private static void init() {
    if(!isDollarInputValid(askForDollars())) {
      System.err.println("Invalid format.");
      init();
    } else {
      parseCoins();
    }
	}
	public static void main(String[] args) {
	  init();
	}
}
