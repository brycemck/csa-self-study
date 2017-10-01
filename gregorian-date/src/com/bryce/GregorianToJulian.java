// Do all the imports

package com.bryce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// The class in its entirety
public class GregorianToJulian {
	// this is what takes input
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	// this is used for calculations
	Integer[] daysInMonths = { 31, 30, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
	// function that returns an int
	public Integer askForMonth() throws IOException {
		int mo = 0;
		
		System.out.println("Please enter the month in a two-digit format.");
		// check to make sure a number was input
		try {
			mo = Integer.parseInt(br.readLine()); // worked
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid format."); // didn't work
			this.askForMonth(); // try again
		}
		return mo; // return the month
	}
	// function that returns an int
	public Integer askForDay() throws IOException {
		int day = 0;
		
		System.out.println("Please enter the day in a two-digit format.");
		// check to make sure a number was input
		try {
			day = Integer.parseInt(br.readLine()); // worked
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid format."); // didn't work
			this.askForDay(); // try again
		}
		return day; // return the day
	}
	// function that returns an int
	public Integer askForYear() throws IOException {
		int year = 0;
		
		System.out.println("Please enter the year in a four-digit format.");
		// check to make sure a number was input
		try {
			year = Integer.parseInt(br.readLine()); // worked
		} catch (NumberFormatException nfe) {
			System.err.println("Invalid format."); // didn't work
			this.askForYear(); // try again
		}
		return year; // return the day
	}
	
	public Integer init() throws IOException {
		int gregDate = 0;
		int mo = this.askForMonth();
		int day = this.askForDay();
		int year = this.askForYear();
		boolean leapYear = false;
		
		for (int i = 0; i <= mo-2; i++) { // accumulate the days from months prior
			gregDate += daysInMonths[i];
		}
		gregDate += day; // add amt of days in selected month
		
		// check if selected year is leap year
		if (year % 4 == 0) {
			if (year % 100 == 0) {
				if (year % 400 == 0) {
					leapYear = true;
				} else {
					leapYear = false;
				}
			} else {
				leapYear = true;
			}
		} else {
			leapYear = false;
		}
		// if leap year AND if selected day was after Feb 28th, add one day
		if (leapYear && (mo == 2 && day == 28) || (mo > 2)) {
			gregDate++;
		}
		
		// return the calculated gregorian date
		return gregDate;
	}
	// MAIN
	public static void main(String[] args) throws IOException {
		// create instance
		GregorianToJulian gregDate = new GregorianToJulian();
		
		// init the class
		int GregorianDate = gregDate.init();
		
		// print dat shit
		System.out.println("The calculated Gregorian Date is: " + GregorianDate);
	}
}