/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domineering;

import java.io.Serializable;
import java.util.Arrays;

/**
 *
 * @author hp
 */
class DomineeringPosition extends Position implements Serializable{
    boolean player1PlaysHorizontal;
    boolean player2PlaysHorizontal;
    
    final static int BLANK = 0;
    final static int PLAYER1 = 1;
    final static int PLAYER2 = -1;
    int[][] board ;
    private int nbr ;

    public int getNbr() {
        return nbr;
    }
     
      public DomineeringPosition(boolean player1PlaysHorizontal , int nbr) {
        this.player1PlaysHorizontal = player1PlaysHorizontal;
        this.player2PlaysHorizontal = !player1PlaysHorizontal;
        this.nbr = nbr ;
        this.board = new int[this.nbr][this.nbr] ; 
    }
      
     public boolean isValidMove(int row, int col, boolean playsHorizontal) {
   

    if (playsHorizontal) {
        // Check if there's enough space for a horizontal move
        return col + 1 < this.nbr && board[row][col + 1] == BLANK && board[row][col] == BLANK;
    } else {
        // Check if there's enough space for a vertical move
        return row + 1 < this.nbr && board[row + 1][col] == BLANK && board[row][col] == BLANK;
    }
}

  public void makeMove(DomineeringMove move) {
    int row = move.startRow;
    int col = move.startCol;

    if (move.isHorizontal) {
        // Update the board for a horizontal move
        board[row][col] = PLAYER2;
        board[row][col + 1] = PLAYER2;
    } else {
        // Update the board for a vertical move
        board[row][col] = PLAYER1;
        board[row + 1][col] = PLAYER1;
    }
}
  public boolean hasPossibleMoves(boolean isHorizontal) {
    for (int i = 0; i < this.nbr; i++) {
        for (int j = 0; j < this.nbr; j++) {
            if (isValidMove(i, j, isHorizontal)) {
                return true;
            }
        }
    }
    return false;
}
   public int getSymbolAt(int row, int col) {
        return board[row][col];
    }

    public void copyFrom(DomineeringPosition other) {
        for (int i = 0; i < this.nbr; i++) {
            System.arraycopy(other.board[i], 0, this.board[i], 0, this.nbr);
        }
        this.player1PlaysHorizontal = other.player1PlaysHorizontal;
        this.player2PlaysHorizontal = other.player2PlaysHorizontal;
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < this.nbr; i++) {
            for (int j = 0; j < this.nbr; j++) {
                sb.append(board[i][j]).append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}