package com.csa;

public class Board {
  int[][] tiles = new int[8][8];
  
  public static void main(String[] args) {
    ChessPiece king = new King();
    king.kill();
  }
  
}