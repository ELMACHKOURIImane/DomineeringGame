/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domineering;

/**
 *
 * @author hp
 */
import static com.mycompany.domineering.GameSearch.DEBUG;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class DomineeringGame extends GameSearch {

    private boolean player1PlaysHorizontal;
    private boolean player2PlaysHorizontal;
    private int nbr ;
    private int niveau ;

    public DomineeringGame(int nbr , int niveau)
    {
        this.nbr = nbr;
        this.niveau = niveau ;
    }
    

    @Override
    public void setDirections(boolean player1PlaysHorizontal, boolean player2PlaysHorizontal) {
        this.player1PlaysHorizontal = player1PlaysHorizontal;
        this.player2PlaysHorizontal = player2PlaysHorizontal;
    }

    @Override
    public Move createMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your move (row column): ");
        String input = scanner.nextLine();
        return createMoveFromInput(input);
    }

   @Override
    protected Position makeMove(Position p, boolean player, Move move) {
        DomineeringPosition dp = (DomineeringPosition) p;
        DomineeringMove dm = (DomineeringMove) move;
        // Make the move
        dp.makeMove(dm);
        return dp;
    }
     @Override
    public boolean reachedMaxDepth(Position p, int depth) {
        boolean ret = false;
        if (depth >= this.niveau) return true;  // You can adjust the maximum depth as needed
        if (wonPosition(p, false)) ret = true;
        else if (wonPosition(p, true)) ret = true;
        return ret;
    }
    public static void main(String[] args) {
        DomineeringGame domineeringGame = new DomineeringGame(6 , 5);
        domineeringGame.setDirections(false, true ); // Set initial directions
        domineeringGame.playGame(new DomineeringPosition(false , 6), true);
    }

    // Add this method to create a move from user input
    @Override
    public Move createMoveFromInput(String input) {
        String[] parts = input.split(" ");
        int row = Integer.parseInt(parts[0]);
        int col = Integer.parseInt(parts[1]);
        
        return new DomineeringMove(row, col, !player2PlaysHorizontal);
    }

   
    
@Override
protected boolean wonPosition(Position p, boolean player) {
    DomineeringPosition dp = (DomineeringPosition) p;

    // Iterate through the board and check for possible moves
            if (player && dp.hasPossibleMoves(true)) {
                // The game is not won if there's at least one valid move for the next player
                return false;
            } else if (!player && dp.hasPossibleMoves(false)) {
                // The game is not won if there's at least one valid move for the next player
                return false;
    }

    // No valid moves, so the game is won
    return true;
}

    @Override
    public float positionEvaluation(Position p, boolean player) {
    
    DomineeringPosition pos = (DomineeringPosition) p;
    boolean isHorizontal = (player && pos.player1PlaysHorizontal) || (!player && pos.player2PlaysHorizontal);
    List<Position> poss = new ArrayList();
    Position[] moves = new DomineeringPosition[this.possibleMoves(p, player).length] ; 
    for(int t = 0 ; t<moves.length ; t++)
    {
        moves[t] = this.possibleMoves(p, player)[t] ; 
    }
    int counth = 0;
    int countv = 0 ; 
    float evaluation = 0 ; 
    
    if(player)
    {
    for (int i = 0; i < this.nbr; i++) {
        for(int j = 0 ; j<this.nbr ; j++ ){
             if(pos.isValidMove(i, j, isHorizontal)) {
                 for(int k =0 ; k<moves.length ; k++)
                 {
                     poss.add(moves[k]);
                 }
                countv=poss.size();  
             } 
             
        }
    }
    for (int i = 0; i < this.nbr; i++) {
        for(int j = 0 ; j<this.nbr ; j++ ){
             if(pos.isValidMove(i, j, !isHorizontal)) {
                for(int k =0 ; k<moves.length ; k++)
                 {
                     poss.add(moves[k]);
                 }
                counth=poss.size();
                 
             } 
             
        }
    
    }
    
    evaluation =countv-counth;
    
    }
    else{
            
 {
    for (int i = 0; i < this.nbr; i++) {
        for(int j = 0 ; j<this.nbr ; j++ ){
             if(pos.isValidMove(i, j, isHorizontal)) {
                 for(int k =0 ; k<moves.length ; k++)
                 {
                     poss.add(moves[k]);
                 }
                counth=poss.size();
                 
             } 
             
        }
       
    }
    for (int i = 0; i < this.nbr; i++) {
        for(int j = 0 ; j<this.nbr ; j++ ){
             if(pos.isValidMove(i, j, !isHorizontal)) {
                 
                for(int k =0 ; k<moves.length ; k++)
                 {
                     poss.add(moves[k]);
                 }
                countv=poss.size();
                 
             } 
             
        }
    
    }
    
    evaluation =counth-countv;
    

    }
    
    }
    
    
    
    return evaluation ; 
}
 @Override
 public float positionEvaluationMobilityBased(Position p, boolean player) {
    DomineeringPosition pos = (DomineeringPosition) p;
    boolean isHorizontal = (player && pos.player1PlaysHorizontal) || (!player && pos.player2PlaysHorizontal);

    int countValidMoves = countValidMoves(pos, isHorizontal);

    // Adjust the evaluation based on the player
    float evaluation = (player) ? countValidMoves : -countValidMoves;

    return evaluation;
}

private int countValidMoves(DomineeringPosition pos, boolean isHorizontal) {
    int count = 0;

    for (int i = 0; i < pos.getNbr(); i++) {
        for (int j = 0; j < pos.getNbr(); j++) {
            if (pos.isValidMove(i, j, isHorizontal)) {
                count++;
            }
        }
    }

    return count;
}
@Override
public float positionEvaluationTerritoryBased(Position p, boolean player) {
    DomineeringPosition pos = (DomineeringPosition) p;
    boolean isHorizontal = (player && pos.player1PlaysHorizontal) || (!player && pos.player2PlaysHorizontal);

    int countPlayerTerritory = countTerritory(pos, player);
    int countOpponentTerritory = countTerritory(pos, !player);

    // Adjust the evaluation based on the player
    float evaluation = countPlayerTerritory - countOpponentTerritory;

    return evaluation;
}

private int countTerritory(DomineeringPosition pos, boolean player) {
    int count = 0;

    for (int i = 0; i < pos.getNbr(); i++) {
        for (int j = 0; j < pos.getNbr(); j++) {
            if (pos.getSymbolAt(i, j) == (player ? 1 : -1)) {
                count++;
            }
        }
    }

    return count;
}
 @Override
protected void printPosition(Position p) {
    System.out.println("Board position:");
    DomineeringPosition pos = (DomineeringPosition) p;

    for (int i = 0; i < this.nbr; i++) {
        System.out.println();
        for (int j = 0; j < this.nbr; j++) {
            if (pos.board[i][j] == DomineeringPosition.PLAYER1) {
                System.out.print("1");
            } else if (pos.board[i][j] == DomineeringPosition.PLAYER2) {
                System.out.print("2");
            } else if(pos.board[i][j] == DomineeringPosition.BLANK) {
                System.out.print("0");
            }
        }
    }
    System.out.println();
}

    @Override
protected Position[] possibleMoves(Position p, boolean player) {
    DomineeringPosition dp = (DomineeringPosition) p;

    // Determine the direction based on the player  
    boolean isHorizontal = (player && dp.player1PlaysHorizontal) || (!player && dp.player2PlaysHorizontal);

    // Create a list to store possible moves
    List<DomineeringPosition> moveList = new ArrayList<>();
    // Iterate through the board and check for valid moves
    for (int i = 0; i < this.nbr; i++) {
        for (int j = 0; j < this.nbr; j++) {
            if (dp.isValidMove(i, j, isHorizontal)) {
                DomineeringPosition newPosition = new DomineeringPosition(!isHorizontal , this.nbr);
                newPosition.copyFrom(dp) ;
                newPosition.makeMove(new DomineeringMove(i, j, isHorizontal));
                moveList.add(newPosition);
            }
        }
    }
    // Convert the list to an array
    DomineeringPosition[] moves = moveList.toArray(new DomineeringPosition[0]);

    // Return the array
    return moves;
  }

     private DomineeringPosition[] trimArray(DomineeringPosition[] array, int length) {
        DomineeringPosition[] trimmedArray = new DomineeringPosition[length];
        System.arraycopy(array, 0, trimmedArray, 0, length);
        return trimmedArray;
    }
     
     @Override
     protected Vector alphaBeta(int depth, Position p, boolean player) {
        return super.alphaBeta(depth, p, player);
    }   
}
