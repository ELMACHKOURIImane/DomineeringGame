/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.domineering;

import java.util.Enumeration;
import java.util.Scanner;
import java.util.Vector;

/**
 *
 * @author hp
 */
public abstract class GameSearch {
     protected boolean player1PlaysHorizontal;
    protected boolean player2PlaysHorizontal;
    public static final boolean DEBUG = false;

    public static boolean PLAYER2 = false;
    public static boolean PLAYER1 = true;

    public GameSearch() {
    }

    protected abstract boolean wonPosition(Position p, boolean player);

    protected abstract float positionEvaluation(Position p, boolean player);

    protected abstract void printPosition(Position p);

    protected abstract Position[] possibleMoves(Position p, boolean player);

    protected abstract Position makeMove(Position p, boolean player, Move move);
    
    protected abstract float positionEvaluationMobilityBased(Position p, boolean player);
    
    protected abstract float positionEvaluationTerritoryBased(Position p, boolean player) ; 

    protected abstract boolean reachedMaxDepth(Position p, int depth);

    protected abstract Move createMove();
    
 // c'est la fonction alaphaBeta_Search qui est utiliser dans le jeux  que ca soit pour la partie humain programme ou pour la partie human humain avec l'aide 
 protected Vector alphaBeta_Search(Position p){
    return maxValue(0, p, Float.MIN_VALUE, Float.MAX_VALUE);
}
public Vector maxValue(int depth, Position p, float alpha, float beta){
    if (reachedMaxDepth(p, depth)){
        Vector v = new Vector(2);
        float valueMobility = positionEvaluationMobilityBased(p, PLAYER1);
        float valueTerritory = positionEvaluationTerritoryBased(p, PLAYER1);
        float combinedValue = combineValues(valueMobility, valueTerritory);
        v.addElement(combinedValue);
        v.addElement(p);
        return v;
    }

    Vector best = new Vector();
    best.addElement(Float.MIN_VALUE);
    best.addElement(p);
    Position[] moves = possibleMoves(p, PLAYER2);
    for (int i = 0; i < moves.length; i++) {
        Vector v2 = minValue(depth + 1, moves[i], alpha, beta);
        float value_best = (Float) best.elementAt(0);
        float value_v2 = (Float) v2.elementAt(0);

        if (value_v2 >= value_best) {
            best = new Vector();
            best.addElement(value_v2);
            best.addElement(moves[i]);
        }

        if (value_best >= beta) {
            return best;
        }

        alpha = Math.max(alpha, value_best);
    }

    return best;
}

public Vector minValue(int depth, Position p, float alpha, float beta) {
    if (reachedMaxDepth(p, depth)) {
        Vector v = new Vector(2);
        float valueMobility = positionEvaluationMobilityBased(p, PLAYER2);
        float valueTerritory = positionEvaluationTerritoryBased(p, PLAYER2);
        float combinedValue = combineValues(valueMobility, valueTerritory);
        v.addElement(combinedValue);
        v.addElement(p);
        return v;
    }
    Vector best = new Vector();
    best.addElement(Float.MAX_VALUE);
    best.addElement(p);
    Position[] moves = possibleMoves(p, PLAYER1);

    for (int i = 0; i < moves.length; i++) {
        Vector v2 = maxValue(depth + 1, moves[i], alpha, beta);
        float value_best = (Float) best.elementAt(0);
        float value_v2 = (Float) v2.elementAt(0);

        if (value_v2 <= value_best) {
            best = new Vector();
            best.addElement(value_v2);
            best.addElement(moves[i]);
        }

        if (value_best <= alpha) {
            return best;
        }

        beta = Math.min(beta, value_best);
    }

    return best;
}
private float combineValues(float value1, float value2) {
    // You can experiment with different ways to combine the two values
    // For simplicity, this example uses a linear combination
    float weight1 = 0.7f; // Adjust weights as needed
    float weight2 = 0.3f;
    return weight1 * value1 + weight2 * value2;
}
   protected Vector alphaBeta(int depth, Position p, boolean player) {
        Vector v = alphaBetaHelper(depth, p, player, 1000000.0f, -1000000.0f);
        return v;
    }
    protected Vector alphaBetaHelper(int depth, Position p, boolean player, float alpha, float beta) {
        if (DEBUG) System.out.println("alphaBetaHelper(" + depth + "," + p + "," + alpha + "," + beta + ")");
        if (reachedMaxDepth(p, depth)){
            Vector v = new Vector(2);
            float value = positionEvaluation(p, player);
            v.addElement(new Float(value));
            v.addElement(p);
            if (DEBUG) {
                System.out.println(" alphaBetaHelper: mx depth at " + depth + ", value=" + value);
            }
            return v;
        }
        Vector best = new Vector();
        Position[] moves = possibleMoves(p, player);
        System.out.println(moves);
        for (int i = 0; i < moves.length; i++) {
            
            Vector v2 = alphaBetaHelper(depth + 1, moves[i], !player, -beta, -alpha);
            float value = -((Float) v2.elementAt(0)).floatValue();
            if (value > beta) {
                if (DEBUG) System.out.println(" ! ! ! value=" + value + ", beta=" + beta);
                beta = value;
                best = new Vector();
                best.addElement(moves[i]);
                Enumeration enum2 = v2.elements();
                enum2.nextElement(); // skip previous value
                while (enum2.hasMoreElements()) {
                    Object o = enum2.nextElement();
                    if (o != null) best.addElement(o);
                }
            }
            if (beta >= alpha) {
                break;
            }
        }
        Vector v3 = new Vector();
        v3.addElement(new Float(beta));
        Enumeration enum2 = best.elements();
        while (enum2.hasMoreElements()) {
            v3.addElement(enum2.nextElement());
        }
        return v3;
    }
    public void playGame(Position startingPosition, boolean player1PlayFirst) {
        Scanner scanner = new Scanner(System.in);

        // Set fixed directions for human and program
        boolean player1PlaysHorizontal = false; // Change this based on your preference
        boolean player2PlaysHorizontal = !player1PlaysHorizontal;

        if (!player1PlayFirst){
            Vector v = alphaBeta(0, startingPosition, PLAYER2);
            startingPosition = (Position) v.elementAt(1);
        }

        while (true) {
            printPosition(startingPosition);
          

            if (player1PlayFirst) {
                System.out.print("Enter your move (row column): ");
                Move move = createMoveFromInput(scanner.nextLine());
                while (!((DomineeringPosition) startingPosition ).isValidMove(((DomineeringMove)move).getStartRow(), ((DomineeringMove)move).getStartCol(), ((DomineeringMove)move).isIsHorizontal())){
                  System.out.print("Enter your move (row column): ");    
                  move = createMoveFromInput(scanner.nextLine());
                }
                startingPosition = makeMove(startingPosition, PLAYER1, move);
            }

            printPosition(startingPosition);

            if (wonPosition(startingPosition, PLAYER1)) {
                System.out.println("PLAYER1 won");
                break;
            }

            Vector v = alphaBeta(0, startingPosition, PLAYER2);

            Enumeration enum2 = v.elements();
            while (enum2.hasMoreElements()) {
                System.out.println(" next element: " + enum2.nextElement());
            }

            startingPosition = (Position) v.elementAt(1);
             if (wonPosition(startingPosition, PLAYER2)) {
                System.out.println("PLAYER2 won");
                break;
            }

           

            if (!player1PlayFirst) {
                System.out.print("Enter your move (row column): ");
                Move move = createMoveFromInput(scanner.nextLine());
                startingPosition = makeMove(startingPosition, PLAYER1, move);
            }
        }
    }
    // Add this method to set the fixed directions
    public void setDirections(boolean humanPlaysHorizontal, boolean programPlaysHorizontal) {
       
    }

    // Add this method to create a move from user input
   
public Move createMoveFromInput(String input) {
    String[] parts = input.split(" ");
    int row = Integer.parseInt(parts[0]);
    int col = Integer.parseInt(parts[1]);
    // Assume the user always plays in the opposite direction of the program
    return new DomineeringMove(row, col, !player2PlaysHorizontal);
}
}
