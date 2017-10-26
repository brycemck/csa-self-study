package com.csa;

import javax.swing.JOptionPane;

public class ChessPiece {
  public boolean team = false; // teams: true = black, false = white
  public int placement = 0;
  public boolean alive = true;
  
  public ChessPiece birth() {
    this.alive = true;
    return this;
  }
  public ChessPiece kill() {
    this.alive = false;
    return this;
  }
  public boolean setTeam(boolean team) {
    this.team = team;
    return this.team;
  }
  public boolean getTeam() {
    return this.team;
  }
  public int setPlacement(int placement) {
    this.placement = placement;
    return this.placement;
  }
  public int getPlacement() {
    return this.placement;
  }
  
  public int inputYMovement() {
    int inputY = 0;
    String yMove = JOptionPane.showInputDialog("Please insert the desired vertical movement.");

    try {
      inputY = Integer.parseInt(yMove);
    } catch (NumberFormatException nfe) {
      System.err.print("Invalid input. Try again.");
      this.inputYMovement();
    }
    return inputY;
  }
  public int inputXMovement() {
    int inputX = 0;
    String xMove = JOptionPane.showInputDialog("Please insert the desired horizontal movement.");

    try {
      inputX = Integer.parseInt(xMove);
    } catch (NumberFormatException nfe) {
      System.err.print("Invalid input. Try again.");
      this.inputXMovement();
    }
    return inputX;
  }
}
