package com.bryce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReverseInteger {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  public static int askForInt() throws IOException {
    int number = 0;
    
    System.out.println("Please enter an integer to reverse.");
    try {
      number = Integer.parseInt(br.readLine());
    } catch (NumberFormatException nfe) {
      System.err.println("Please enter a valid integer.");
      ReverseInteger.askForInt();
    }
    
    return number;
  }
  public static int reverseInt(int num) {
    char[] stringifiedNum = String.valueOf(num).toCharArray();
    char[] reversedStringifiedChars = new char[stringifiedNum.length];
    int reversedNum = 0;
    
    int x = 0;
    for (int i = stringifiedNum.length-1; i >= 0; i--) {
      reversedStringifiedChars[x] = stringifiedNum[i];
      x++;
    }
    
    reversedNum = Integer.parseInt(String.valueOf(reversedStringifiedChars));
    return reversedNum;
  }
  
  public static void main(String[] args) throws IOException {
    int numToReverse = ReverseInteger.askForInt();
   
    System.out.println("Your reversed integer is: " + ReverseInteger.reverseInt(numToReverse));
  }
}