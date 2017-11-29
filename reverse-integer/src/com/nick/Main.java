
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*;

public class Main extends ffdfdafd { 
public static void main(String[] args) {
  boolean isTrue = false;	
  int normValue;  
  char newChar;
  String wantValue = " ";
while (isTrue == false) { 
  try{
  wantValue = JOptionPane.showInputDialog("Please insert a number to reverse");
  normValue = Integer.valueOf(wantValue);
  isTrue = true;
  }
  catch (NumberFormatException e) {
    JOptionPane.showMessageDialog(null, "Please insert an integer, nothing else.", "Int error", JOptionPane.ERROR_MESSAGE);
    
  }
}
  StringBuilder newValue = new StringBuilder(wantValue);
    for (int i = 0; i < wantValue.length(); i++) {
     newChar = wantValue.charAt(wantValue.length() - i - 1);
     newValue.setCharAt(i, newChar);
  }
  JOptionPane.showMessageDialog(null, "The value of your original value is " + wantValue + " and the value of your new value is " + newValue, "Result", JOptionPane.INFORMATION_MESSAGE);  
}
}