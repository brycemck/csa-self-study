package com.zane;

import java.util.Scanner;



public class julienConverter {


// Establish Variables

public static int standardMonth;

public static int standardDay;

public static int standardYear;

public static int julianDate = 0;

public static Scanner month = new Scanner(System.in);

public static Scanner day = new Scanner(System.in);

public static Scanner year = new Scanner(System.in);

public static int[] allMonths = {31,28,31,30,31,30,31,31,30,31,30,31};

public static int[] leapYearMonths = {31,29,31,30,31,30,31,31,30,31,30,31};


// User input for Month

public static int monthReturn(){

System.out.println("Enter the month in numerical form mm.");

standardMonth = month.nextInt();

return standardMonth;

}


// User input for Day

public static int dayReturn(){

System.out.println("Enter the day in numerical form dd.");

standardDay = day.nextInt();

return standardDay;

}


// User input for Year

public static int yearReturn(){

System.out.println("Enter the year between 2000 and 2017 in numerical form yyyy.");

standardYear = year.nextInt();

System.out.println("Your year " + standardYear);

return standardYear;

}


// Error Searching Method for Day

public static void errorSearchDay(){


if ((standardMonth == 1 || standardMonth == 3 || standardMonth == 5 || standardMonth == 7 || standardMonth == 8 || standardMonth == 10 || standardMonth == 12) && (standardDay >= 1 && standardDay <= 31)) {

System.out.println("Your day " + standardDay);

}


else if((standardMonth == 2) && (standardDay >0 && standardDay <= 29)){

System.out.println("Your day " + standardDay);

}

else if((standardMonth == 4 || standardMonth == 6 || standardMonth == 9 || standardMonth == 11) && (standardDay > 0 && standardDay <=30)){

System.out.println("Your day " + standardDay);

}

else{

System.out.println("This is an invalid input, please try again");

System.out.println("A correct example response would be 12");

dayReturn();

errorSearchDay();

}



}


// Error Search Method for Year

public static void errorSearchYear(){

if ((standardMonth == 2) && (standardDay == 29) && !(standardYear == 2000 || standardYear == 2004 || standardYear == 2008 || standardYear == 2012 || standardYear == 2016)){

System.out.println("This is not a leap year, so you cannot choose the 29th");

dayReturn();

errorSearchYear();


}

else if(standardYear >= 2000 && standardYear <= 2017){

System.out.println("Your year " + standardYear);

}

else{

while (standardYear < 2000 || standardYear > 2017){

System.out.println("This is an invalid input, please try again");

System.out.println("A correct example response would be 2005");

yearReturn();

System.out.println("Your year " + standardYear);

}

}

}


// Error search method for month

public static void errorSearchMonth(){

if (standardMonth >= 1 && standardMonth <= 12){

System.out.println("Your month " + standardMonth);

}

else {

while (standardMonth < 1 || standardMonth > 12){

System.out.println("This is an invalid input, please try again");

System.out.println("A correct example response would be 10");

monthReturn();

System.out.println("Your month " + standardMonth);

}

}

}


public static void main(String[] args){


// Introduction

System.out.println("This program will take the standard date mm/dd/yyyy and turn it into Julian form.");


// Call method for Month

monthReturn();


// Call method for Error Search for Month

errorSearchMonth();


// Call method for Day

dayReturn();


// Call method for Error Search for Day

errorSearchDay();


// Call method for Year

yearReturn();


// Call method for Error Search for Year

errorSearchYear(); 


// Show Final Date Chosen

System.out.println("Your date chosen is " + standardMonth + "/" + standardDay + "/" + standardYear);


// Convert Standard Date to Julian Date accounting for leap years

if (standardYear == 2000 || standardYear == 2004 || standardYear == 2008 || standardYear == 2012 || standardYear == 2016){


for (int i = 0; i <= standardMonth - 2; i++){

julianDate += leapYearMonths[i];

}

}

else{


for (int j = 0; j <= standardMonth - 2; j++){

julianDate += allMonths[j];

}

}


julianDate += standardDay;

System.out.println("Your Julian Date is " + julianDate + " for the year " + standardYear);


// Close Scanners

month.close();

day.close();

year.close();



}


}