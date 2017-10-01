/* Julian Date Conversion
 * A simple program to convert from Galilean Date to Julian Date
 * @author nick murphy 9/2/2017
 */

package com.nick;

//Import needed classes
import javax.swing.*;

public class JulianDate {
	public static void main(String[] args) 
	{
		//Initialize values for checks
		boolean monthTrue = false;
		boolean dayTrue = false;
		boolean yearTrue = false;
		//Initialize strings for data input
		String yearInput = " ";
		String monthInput = " ";
		String dayInput = " ";
		//Initialize integers for calculation 
		int month = 0;
		int day = 0;
		int year = 0;
		//Initialize arrays
		int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int[] monthsLeap = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		//Create a frame for the dialog box.
		JFrame frame = new JFrame("Julian Converter");
		//Only allow the user to pass on if the month is not greater than 12 or less than 0
		while (monthTrue != true) {
			monthInput = JOptionPane.showInputDialog(frame, "Please input your desired month");
			//Try to gather input from the user
			try {
			//Change the string to an integer variable.
			month = Integer.parseInt(monthInput);
			if (month < 1 || month > 12) {
				JOptionPane.showMessageDialog(frame, "Error: Your month must be an integer between 1 and 12", "Month Error", JOptionPane.ERROR_MESSAGE);
			} else {
				monthTrue = true;
			} 
			//Catch the exception if the input was not an integer.
			}	catch (NumberFormatException e) {
				//Display an error message specifying that the answer was not an integer.
				JOptionPane.showMessageDialog(frame, "Error: only use integers for your date", "Non-int error", JOptionPane.ERROR_MESSAGE);
				monthTrue = false;
			} 
		} 
		while (yearTrue != true) {
			yearInput = JOptionPane.showInputDialog(frame, "Please input your desired year");
			try {
			//Change the string to an integer variable.
			year = Integer.parseInt(yearInput);
			yearTrue = true;
			} catch (NumberFormatException e) {
				yearTrue = false;
				JOptionPane.showMessageDialog(frame, "Error: only use integers for your date", "Non-int error", JOptionPane.ERROR_MESSAGE);
			}
		}
		//Check if the year is a leap year
		int leapCheck = year % 4;
		while (dayTrue != true) {
			dayInput = JOptionPane.showInputDialog(frame, "Please input your desired day");
			try {
			//Change the string to an integer variable.
			day = Integer.parseInt(dayInput);
			//Check for each month if the specified amount of days is correct; otherwise, produce an error and ask them again
			if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
				if (day > 31 || day < 1) {
					JOptionPane.showMessageDialog(frame, "Error: your day for this month must be an integer between 1 and 31", "Day Error", JOptionPane.ERROR_MESSAGE);
				} else {
					dayTrue = true;
				}
			}
			if (month == 4 || month == 6 || month == 9 || month == 11) {
				if (day > 30 || day < 1) {
					JOptionPane.showMessageDialog(frame, "Error: your day for this month must be an integer between 1 and 30", "Day Error", JOptionPane.ERROR_MESSAGE);					
				} else {
					dayTrue = true;
				}
			}
			if (month == 2) {
				if (leapCheck == 0) {
					if (day > 29 || day < 1) {
						JOptionPane.showMessageDialog(frame, "Error: your day for this month must be an integer between 1 and 29", "Day Error", JOptionPane.ERROR_MESSAGE);
					} else {
						dayTrue = true;
					}
				} else if (leapCheck != 0) {
					if (day > 28 || day < 1) {
						JOptionPane.showMessageDialog(frame, "Error: your day for this month must be an integer between 1 and 28", "Day Error", JOptionPane.ERROR_MESSAGE);
					} else {
						dayTrue = true;
					}
				}
			}
			} catch (NumberFormatException e) {
				dayTrue = false;
				JOptionPane.showMessageDialog(frame, "Error: only use integers for your date", "Non-int error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		//Add the day/month to create the Julian date.
		int julDate = 0;
		for (int i = 1; i < (month); i++) {
			if (leapCheck == 0) {
				julDate += monthsLeap[i];
			} else {
				julDate += months[i];
			}
		}
		julDate += day;
		//Change the type of the Julian Date back to a string for display.
		String.valueOf(julDate);
		//Display the Julian Date in a dialog box.
		JOptionPane.showMessageDialog(frame, "Your date produces the Julian Date of: " + julDate, "Julian Result", JOptionPane.PLAIN_MESSAGE);
		System.exit(0);
	}
}