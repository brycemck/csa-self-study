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

public class CoinCounter {
	static int inputDollars = 0;
	static double inputCents = 0;
	
	public static String askForDollars() {
	  return JOptionPane.showInputDialog("Please input a dollar value. (x.xx format)").replace(",", ""); // remove any commas
	}
	
	public static double numberOfQuartersFromDollars(int dollars) {
		return dollars * 4;
	}
	public static double numberOfQuartersFromCents(double cents) {
		inputCents = inputCents - (Math.floor(cents / 25) * 25);
		return Math.floor(cents / 25);
	}
	public static double numberOfDimesFromCents(double cents) {
		inputCents = inputCents - (Math.floor(cents / 10) * 10);
		return Math.floor(cents / 10);
	}
	public static double numberOfNickelsFromCents(double cents) {
		inputCents = inputCents - (Math.floor(cents / 5) * 5);
		return Math.floor(cents / 5);
	}
	
	public static void parseCoins() {
		System.out.println("Quarters: " + (numberOfQuartersFromDollars(inputDollars) + numberOfQuartersFromCents(inputCents)));
		System.out.println("Dimes: " + numberOfDimesFromCents(inputCents));
		System.out.println("Nickels: " + numberOfNickelsFromCents(inputCents));
		System.out.println("Pennies: " + inputCents);
	}

	public static boolean isDollarInputValid(String input) {
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
