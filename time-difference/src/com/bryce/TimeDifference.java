package com.bryce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TimeDifference {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  public static int[] askForTime() throws IOException {
    int[] time = new int[2];
    String rawTime = br.readLine();
    
    if (!rawTime.contains(":")) {
      System.err.println("Invalid time. Please try again.");
      TimeDifference.askForTime();
    }
    
    String[] timeSplit = rawTime.split("\\:");
    try {
      time[0] = Integer.parseInt(timeSplit[0]);
      time[1] = Integer.parseInt(timeSplit[1]);
      
    } catch (NumberFormatException nfe) {
      System.err.println("Invalid time. Please try again.");
      TimeDifference.askForTime();
    }
    
    if (time[0] > 23 || time[0] < 0 || time[1] > 59 || time[1] < 0) {
      System.err.println("Invalid time. Please try again.");
      TimeDifference.askForTime();
    }
    
    return time;
  }
  public static int[] subtractTimes(int[] timeOne, int[] timeTwo) {
    int[] timeDifferences = new int[2];
    
    timeDifferences[0] = (timeOne[0] - timeTwo[0]);
    timeDifferences[1] = (timeOne[1] - timeTwo[1]);
    
    return timeDifferences;
  }
  public static void main(String[] args) throws IOException {
    System.out.println("Input the first time in 24hr format (xx:xx)");
    int[] timeOne = TimeDifference.askForTime();
    System.out.println("Input the second time in 24hr format (xx:xx)");
    int[] timeTwo = TimeDifference.askForTime();
    
    int[] timeDifference = TimeDifference.subtractTimes(timeOne, timeTwo);
    System.out.println("The difference between the two given times is " + timeDifference[0] + " hours and " + timeDifference[1] + " minutes.");
  }
}