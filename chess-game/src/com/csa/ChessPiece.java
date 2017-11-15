package com.csa;

public class ChessPiece {
  public boolean team = false; // teams: true = black, false = white
  public int[][] placement = new int[7][7];
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
  public void calculatePotentialPositions() {
    
  }
  public void test() {
    this.placement = [4][3];
  }
}
